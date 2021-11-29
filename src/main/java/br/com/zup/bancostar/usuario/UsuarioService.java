package br.com.zup.bancostar.usuario;

import br.com.zup.bancostar.exception.CpfJaCadastrado;
import br.com.zup.bancostar.exception.EmailJaCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario) {
        if (validarCadastroUsuario(usuario.getEmail(), usuario.getCpf())) {
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


}
