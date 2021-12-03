package br.com.zup.bancostar.usuario;

import br.com.zup.bancostar.enuns.Status;
import br.com.zup.bancostar.usuario.dtos.UsuarioAtualizadoDTO;
import br.com.zup.bancostar.usuario.dtos.UsuarioDTO;
import br.com.zup.bancostar.usuario.dtos.UsuarioSaidaDTO;
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
    public UsuarioSaidaDTO cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {

        UsuarioSaidaDTO usuarioSaidaDTO = modelMapper.map(usuarioDTO, UsuarioSaidaDTO.class);
        usuarioSaidaDTO.setTipo(usuarioDTO.getTipo().getNomeTipo());
        usuarioSaidaDTO.setStatus(Status.ATIVO);
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.salvarUsuario(usuario);
        return usuarioSaidaDTO;

    }

    @GetMapping("/{cpf}")
    public UsuarioSaidaDTO buscarUsuario(@PathVariable String cpf) {
        return modelMapper.map(usuarioService.buscarUsuario(cpf), UsuarioSaidaDTO.class) ;
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable String cpf) {
        usuarioService.deletarUsuario(cpf);
    }

    @PutMapping("/{cpf}")
    public UsuarioSaidaDTO atualizarUsuario(@PathVariable String cpf, @RequestBody @Valid UsuarioAtualizadoDTO
            usuarioAtualizadoDTO) {
        Usuario usuarioAtualizado = modelMapper.map(usuarioAtualizadoDTO, Usuario.class);
        UsuarioSaidaDTO usuarioSaidaDTO = modelMapper.map(usuarioService.atualizarUsuario(cpf, usuarioAtualizado),
                UsuarioSaidaDTO.class);

        return usuarioSaidaDTO;
    }

    @PutMapping("/reative/{cpf}")
    public void reativarUsuario(@PathVariable String cpf) {
        usuarioService.reativarContaDoUsuario(cpf);
    }
}
