package br.com.zup.bancostar.conta;


import br.com.zup.bancostar.conta.dtos.ContaComUsuarioDTO;
import br.com.zup.bancostar.conta.dtos.ContaEntradaDTO;
import br.com.zup.bancostar.conta.dtos.ContaSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ContaSaidaDTO cadastrar(@RequestBody @Valid ContaEntradaDTO contaDTO) {
        Conta conta = modelMapper.map(contaDTO, Conta.class);
        ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.cadastrarConta(conta), ContaSaidaDTO.class);
        return contaSaidaDTO;
    }

    @GetMapping("/{cpf}")
    public ContaSaidaDTO buscarContaPorID(@PathVariable String cpf) {
        ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.buscarContaPorCpf(cpf), ContaSaidaDTO.class);
        return contaSaidaDTO;
    }

    @PutMapping
    public ContaSaidaDTO vincularUsuario(@RequestBody @Valid ContaComUsuarioDTO contaComUsuarioDTO) {
        ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.vincularUsuarioNaConta(contaComUsuarioDTO.getContaId()
                , contaComUsuarioDTO.getUsuarioId()), ContaSaidaDTO.class);
        return contaSaidaDTO;
    }

    @DeleteMapping("/{cpf}")
    public void deletarConta(@PathVariable String cpf) {
        contaService.excluirConta(cpf);
    }

}
