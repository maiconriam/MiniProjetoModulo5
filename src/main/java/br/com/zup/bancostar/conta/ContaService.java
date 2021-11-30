package br.com.zup.bancostar.conta;

import br.com.zup.bancostar.exception.ContaNaoEncontrada;
import br.com.zup.bancostar.usuario.Usuario;
import br.com.zup.bancostar.usuario.UsuarioRepository;
import br.com.zup.bancostar.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired ContaRepository contaRepository;
    @Autowired UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;

    public Conta cadastrarConta(Conta conta){
       conta.setDataDeCriacao(LocalDate.now());
        return contaRepository.save(conta);
    }
    public Conta vincularUsuarioNaConta(Integer id, String cpf){
        Usuario usuario = usuarioService.buscarUsuario(cpf);
        Optional<Conta>contaOptional = contaRepository.findById(id);

        if ((contaOptional.isEmpty())){
            throw new ContaNaoEncontrada("Conta não encontrada");
        }
        contaOptional.get().setUsuario(usuario);

        return contaRepository.save(contaOptional.get());
    }

    public Conta buscarContaPorCpf(String cpf){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(cpf);
        if (optionalUsuario.isPresent()){
            Optional<Conta>optionalConta = contaRepository.findByUsuarioCpf(optionalUsuario.get().getCpf());
            if (optionalConta.isPresent()){
                return optionalConta.get();
            }
            throw new RuntimeException("Conta não encontrada");
        }
        throw new RuntimeException("Usuario não encontrado");
    }

    public void excluirConta(Integer id){
        if (contaRepository.existsById(id)){
            contaRepository.deleteById(id);
        }else{
            throw new ContaNaoEncontrada("Conta não encontrada");
        }
    }

}
