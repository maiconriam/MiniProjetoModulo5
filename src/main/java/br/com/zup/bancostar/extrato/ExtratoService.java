package br.com.zup.bancostar.extrato;


import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.conta.ContaRepository;
import br.com.zup.bancostar.conta.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    ContaService contaService;

//    public Extrato exibirExtrato(String cpf){
//        Conta conta = contaService.buscarContaPorCpf(cpf);
//        return  conta.getExtrato();
//
//    }


}
