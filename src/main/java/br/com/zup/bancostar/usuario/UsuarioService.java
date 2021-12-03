package br.com.zup.bancostar.usuario;

import br.com.zup.bancostar.enuns.Status;
import br.com.zup.bancostar.exception.CpfJaCadastrado;
import br.com.zup.bancostar.exception.EmailJaCadastrado;
import br.com.zup.bancostar.exception.UsuarioNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario) {
        if (validarCadastroUsuario(usuario.getEmail(), usuario.getCpf())) {
            usuario.setStatus(Status.ATIVO);
            usuarioRepository.save(usuario);
        }
    }

    private boolean validarCadastroUsuario(String novoEmail, String novoCpf) {

        if (!usuarioRepository.existsById(novoCpf)) {
            for (Usuario usuarioReferencia : usuarioRepository.findAll()) {
                if (usuarioReferencia.getEmail().contains(novoEmail)) {
                    throw new EmailJaCadastrado("Este email já está cadastrado.");
                }
            }
        } else {
            throw new CpfJaCadastrado("Este CPF já está atrelado a um usuário.");
        }
        return true;
    }

    public Usuario buscarUsuario(String cpf) {

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(cpf);

        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }
        throw new UsuarioNaoEncontrado("Este Usuario não está cadastrado.");
    }

    public void deletarUsuario(String cpf) {
        Usuario usuario = buscarUsuario(cpf);
        usuario.setStatus(Status.DESATIVADO);
        usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(String cpf, Usuario usuario) {
        Usuario usuarioASerAtualizado = buscarUsuario(cpf);

        usuarioASerAtualizado.setNome(usuario.getNome());
        usuarioASerAtualizado.setEmail(usuario.getEmail());
        usuarioASerAtualizado.setTelefone(usuario.getTelefone());
        usuarioASerAtualizado.setTipo(usuario.getTipo());
        usuarioRepository.save(usuarioASerAtualizado);

        return usuarioASerAtualizado;
    }

    public Usuario reativarContaDoUsuario(String cpf){
        Usuario usuario = buscarUsuario(cpf);
        usuario.setStatus(Status.ATIVO);
        usuarioRepository.save(usuario);

        return usuario;
    }
}
