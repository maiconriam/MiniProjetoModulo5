package br.com.zup.bancostar.conta;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping ("/conta")
public class ContaController {
    @Autowired ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ContaSaidaDTO cadastrar(@RequestBody @Valid ContaDTO contaDTO){
        Conta conta = modelMapper.map(contaDTO,Conta.class);
        ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.cadastrarConta(conta),ContaSaidaDTO.class);
        return contaSaidaDTO;
    }
}
