package br.com.zup.bancostar.conta;

import br.com.zup.bancostar.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired ContaRepository contaRepository;
    //@Autowired UsuarioRepository usuarioRepository

    public Conta cadastrarConta(Conta conta){
       conta.setDataDeCriacao(LocalDate.now());
        return contaRepository.save(conta);
    }

    public Conta buscarContaPorCpf(String cpf){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(cpf);
        if (optionalUsuario.isPresent()){
            Optional<Conta>optionalConta = contaRepository.findByCpf(optionalUsuario.get().getCpf());
            if (optionalConta.isPresent()){
                return optionalConta.get();
            }
            throw new RuntimeException("Conta não encontrada");
        }
        throw new RuntimeException("Usuario não encontrado");
    }

}
