package br.com.zup.bancostar.usuario;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


}
