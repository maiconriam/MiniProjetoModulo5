package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.conta.ContaRepository;
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


    public Operacao depositar (Operacao operacao, Integer id){
        Optional<Conta> optionalOperacao = contaRepository.findById(id);
        if(optionalOperacao.isPresent()){
            operacao.setDataHoraOperacao(LocalDateTime.now());
            operacao.setConta(optionalOperacao.get());

            Operacao operacaoSalva = operacaoRepository.save(operacao);
            contaRepository.updateValorConta(id, operacao.getValor());
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
            return operacaoSalva;
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
