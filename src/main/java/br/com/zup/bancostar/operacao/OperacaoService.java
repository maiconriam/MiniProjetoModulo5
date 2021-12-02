package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.conta.ContaRepository;
import br.com.zup.bancostar.conta.ContaService;
import br.com.zup.bancostar.enuns.TipoOperacao;
import br.com.zup.bancostar.exception.ContaRepetida;
import br.com.zup.bancostar.exception.SaldoInsuficiente;
import br.com.zup.bancostar.extrato.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoRepository operacaoRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ExtratoService extratoService;
    @Autowired
    private ContaService contaService;

    public Operacao registrarOperacao(TipoOperacao tipoOperacao, double valor, Integer conta, Integer contaDestino) {
        switch (tipoOperacao){
            case DEPOSITO:


            case SAQUE:


            case TRANSFERENCIA:


            default:
                throw new RuntimeException("Operacao não permitida");
        }

    }

    public Operacao depositar (Operacao operacao, Integer id){
        Conta conta = contaService.buscaContaValida(id);
        operacao.setDataHoraOperacao(LocalDateTime.now());
        operacao.setConta(conta);

        Operacao operacaoSalva = operacaoRepository.save(operacao);
        contaRepository.updateValorConta(id, operacao.getValor());

        double saldoExtrato = conta.getValor()+ operacao.getValor();
        extratoService.novoExtrato(operacao, operacao.getConta(), saldoExtrato);

        return operacaoSalva;

    }

    public Operacao sacar (Operacao operacao, Integer id){
        Conta conta = contaService.buscaContaValida(id);
        verificarSaldo(conta, operacao.getValor());
        operacao.setDataHoraOperacao(LocalDateTime.now());
        operacao.setConta(conta);

        Operacao operacaoSalva = operacaoRepository.save(operacao);
        contaRepository.updateValorConta(id, operacao.getValor());

        double saldoExtrato = conta.getValor()+ operacao.getValor()* -1;
        extratoService.novoExtrato(operacao, operacao.getConta(), saldoExtrato);

        return operacaoSalva;
    }

    public Operacao transferir (Operacao operacao, Integer idConta, Integer idContaDestino){
        Conta contaOrigem = contaService.buscaContaValida(idConta);
        Conta contaDestino = contaService.buscaContaValida(idContaDestino);
        verificarSaldo(contaOrigem, operacao.getValor());
        if (contaOrigem.equals(contaDestino)) {
            throw new ContaRepetida("Você nao pode transferir para a mesma conta");
        }

        operacao.setDataHoraOperacao(LocalDateTime.now());
        operacao.setConta(contaOrigem);

        Operacao operacaoSalva = operacaoRepository.save(operacao);
        contaRepository.updateValorConta(idConta, operacao.getValor()*-1);
        contaRepository.updateValorConta(idContaDestino, operacao.getValor());

        double saldoExtratoOrigem = contaOrigem.getValor() - operacao.getValor();
        extratoService.novoExtrato(operacao, contaOrigem, saldoExtratoOrigem);

        double saldoExtratoDestino = contaDestino.getValor() + operacao.getValor();
        extratoService.novoExtrato(operacao, contaDestino, saldoExtratoDestino);

        return operacaoSalva;
    }

    private Operacao salvarOperacao(TipoOperacao tipoOperacao, double valor, Conta conta){
        Operacao operacao = new Operacao();
        operacao.setTipoOperacao(tipoOperacao);
        operacao.setValor(valor);
        operacao.setConta(conta);
        operacao.setDataHoraOperacao(LocalDateTime.now());

        return operacaoRepository.save(operacao);
    }

    private void verificarSaldo(Conta conta, double valorOperacao){
        if (valorOperacao > conta.getValor()){
            throw new SaldoInsuficiente("Saldo insuficiente");
        }
    }
}

