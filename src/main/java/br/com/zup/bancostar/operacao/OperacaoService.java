package br.com.zup.bancostar.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OperacaoService {

    @Autowired
    OperacaoRepository operacaoRepository;

    public Operacao depositar (Operacao operacao){
        operacao.setDataDaOperacao(LocalDate.now());
        operacao.getContaDeDestino().setValor(operacao.getContaDeDestino().getValor() + operacao.getValor());

        return operacaoRepository.save(operacao);
    }
}
