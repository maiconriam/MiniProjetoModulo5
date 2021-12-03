package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.conta.ContaRepository;
import br.com.zup.bancostar.conta.ContaService;
import br.com.zup.bancostar.enuns.TipoOperacao;
import br.com.zup.bancostar.exception.ContaNaoEncontrada;
import br.com.zup.bancostar.exception.ContaRepetida;
import br.com.zup.bancostar.exception.OperacaoNaoPermitida;
import br.com.zup.bancostar.exception.SaldoInsuficiente;
import br.com.zup.bancostar.operacao.dto.ExtratoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoRepository operacaoRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ContaService contaService;

    public Operacao registrarOperacao(TipoOperacao tipoOperacao, double valor, Integer conta, Integer contaDestino) {
        if(tipoOperacao.equals(TipoOperacao.DEPOSITO)){
            return this.depositar(valor, conta);
        }
        if(tipoOperacao.equals(TipoOperacao.SAQUE)){
            return this.sacar(valor, conta);
        }
        if(tipoOperacao.equals(TipoOperacao.TRANSFERENCIA)){
            return this.transferir(valor, conta, contaDestino);
        }

        throw new OperacaoNaoPermitida("Operação não permitida");
    }

    public Operacao depositar (double valor, Integer id){
        Conta conta = contaService.buscaContaValida(id);

        Operacao operacaoSalva = this.salvarOperacao(TipoOperacao.DEPOSITO, valor, conta);
        contaRepository.updateValorConta(id, operacaoSalva.getValor());

        return operacaoSalva;
    }

    public Operacao sacar (double valor, Integer id){
        Conta conta = contaService.buscaContaValida(id);
        verificarSaldo(conta, valor);

        Operacao operacaoSalva = this.salvarOperacao(TipoOperacao.SAQUE, valor*-1, conta);
        contaRepository.updateValorConta(id, operacaoSalva.getValor());

        return operacaoSalva;
    }

    public Operacao transferir (double valor, Integer idConta, Integer idContaDestino){
        Conta contaOrigem = contaService.buscaContaValida(idConta);
        Conta contaDestino = contaService.buscaContaValida(idContaDestino);
        verificarSaldo(contaOrigem,valor);
        if (contaOrigem.equals(contaDestino)) {
            throw new ContaRepetida("Você nao pode transferir para a mesma conta");
        }

        Operacao operacaoOrigemSalva = this.salvarOperacao(TipoOperacao.TRANSFERENCIA, valor*-1, contaOrigem);
        contaRepository.updateValorConta(idConta, operacaoOrigemSalva.getValor());

        Operacao operacaoDestinoSalva = this.salvarOperacao(TipoOperacao.TRANSFERENCIA, valor, contaDestino);
        contaRepository.updateValorConta(idContaDestino, operacaoDestinoSalva.getValor());

        return operacaoOrigemSalva;
    }

    public ExtratoDTO extrato(Integer id) {
        Conta conta = contaRepository.findById(id).orElseThrow(
                () -> new ContaNaoEncontrada("Conta não encontrada")
        );
        List<Operacao> operacoes = operacaoRepository.findAllByContaId(id);
        ExtratoDTO extratoDTO = new ExtratoDTO();
        extratoDTO.setSaldo(conta.getSaldo());
        for(Operacao operacao : operacoes){
            extratoDTO.getOperacoes().add(new ExtratoDTO.ExtratoDataDTO(operacao.getTipoOperacao(), operacao.getValor(),
                    operacao.getDataHoraOperacao()));
        }
        return extratoDTO;
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
        if (valorOperacao > conta.getSaldo()){
            throw new SaldoInsuficiente("Saldo insuficiente");
        }
    }

}

