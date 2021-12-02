package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.conta.ContaRepository;
import br.com.zup.bancostar.extrato.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoRepository operacaoRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ExtratoService extratoService;


    public Operacao depositar (Operacao operacao, Integer id){
        Optional<Conta> optionalOperacao = contaRepository.findById(id);
        if(optionalOperacao.isPresent()){
            operacao.setDataHoraOperacao(LocalDateTime.now());
            operacao.setConta(optionalOperacao.get());

            Operacao operacaoSalva = operacaoRepository.save(operacao);
            contaRepository.updateValorConta(id, operacao.getValor());

            double saldoExtrato = optionalOperacao.get().getValor()+ operacao.getValor();
            extratoService.novoExtrato(operacao, operacao.getConta(), saldoExtrato);

            return operacaoSalva;
        }
        throw new RuntimeException("Conta não encontrada");
    }

    public Operacao sacar (Operacao operacao, Integer id){
        Optional<Conta> conta = contaRepository.findById(id);
        if(conta.isPresent()){
            operacao.setDataHoraOperacao(LocalDateTime.now());
            operacao.setConta(conta.get());

            Operacao operacaoSalva = operacaoRepository.save(operacao);
            contaRepository.updateValorConta(id, operacao.getValor()*-1);

            double saldoExtrato = conta.get().getValor() - operacao.getValor();
            extratoService.novoExtrato(operacao, operacao.getConta(), saldoExtrato);

            return operacaoSalva;
        }
        throw new RuntimeException("Conta não encontrada");
    }

    public Operacao transferir (Operacao operacao, Integer idConta, Integer idContaDestino){
        Optional<Conta> contaOrigem = contaRepository.findById(idConta);
        Optional<Conta> contaDestino = contaRepository.findById(idContaDestino);
        if(contaOrigem.isPresent() && contaDestino.isPresent()){
            operacao.setDataHoraOperacao(LocalDateTime.now());
            operacao.setConta(contaOrigem.get());

            Operacao operacaoSalva = operacaoRepository.save(operacao);
            contaRepository.updateValorConta(idConta, operacao.getValor()*-1);
            contaRepository.updateValorConta(idContaDestino, operacao.getValor());

            double saldoExtratoOrigem = contaOrigem.get().getValor() - operacao.getValor();
            extratoService.novoExtrato(operacao, contaOrigem.get(), saldoExtratoOrigem);

            double saldoExtratoDestino = contaDestino.get().getValor() + operacao.getValor();
            extratoService.novoExtrato(operacao, contaDestino.get(), saldoExtratoDestino);

            return operacaoSalva;
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
