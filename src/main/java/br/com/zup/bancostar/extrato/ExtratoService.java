package br.com.zup.bancostar.extrato;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.exception.ContaNaoEncontrada;
import br.com.zup.bancostar.operacao.Operacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Extrato exibirExtrato(Integer id){
        Optional<Extrato> extratoOptional = extratoRepository.findById(id);
        if(extratoOptional.isPresent()){
            return extratoOptional.get();
        }
        throw new ContaNaoEncontrada("Conta não encontrada");
    }
}