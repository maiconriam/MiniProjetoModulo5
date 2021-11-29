package br.com.zup.bancostar.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
    @Autowired ContaRepository contaRepository;

    public Conta cadastrarConta(Conta conta){
       conta.setDataDeCriacao(LocalDate.now());
        return contaRepository.save(conta);
    }


}
