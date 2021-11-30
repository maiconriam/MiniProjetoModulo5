package br.com.zup.bancostar.usuario;

import br.com.zup.bancostar.usuario.dtos.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/{cpf}")
    public Usuario buscarUsuario(@PathVariable String cpf) {
        return usuarioService.buscarUsuario(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void deletarUsuario(@PathVariable String cpf) {
        usuarioService.deletarUsuario(cpf);
    }
}
