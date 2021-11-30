package br.com.zup.bancostar.usuario;

import br.com.zup.bancostar.usuario.dtos.UsuarioAtualizadoDTO;
import br.com.zup.bancostar.usuario.dtos.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;
    ModelMapper modelMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.usuarioService = usuarioService;
    }

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

    @PutMapping("/{cpf}")
    public Usuario atualizarUsuario(@PathVariable String cpf, @RequestBody @Valid UsuarioAtualizadoDTO
            usuarioAtualizadoDTO) {
        Usuario usuarioAtualizado = modelMapper.map(usuarioAtualizadoDTO, Usuario.class);

        return usuarioService.atualizarUsuario(cpf, usuarioAtualizado);
    }
}
