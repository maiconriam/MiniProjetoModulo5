package br.com.zup.bancostar.extrato;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.operacao.Operacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoService {

    @Autowired
    private ExtratoRepository extratoRepository;

    public void novoExtrato(Operacao operacao, Conta conta, double saldo){
        Extrato extrato = new Extrato();
        extrato.setSaldo(saldo);
        extrato.setConta(conta);
        extrato.setOperacaos(operacao);
        extratoRepository.save(extrato);
    }
}