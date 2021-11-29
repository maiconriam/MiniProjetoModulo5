package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.operacao.dtos.EntradaDTO;
import br.com.zup.bancostar.operacao.dtos.SaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    OperacaoService operacaoService;

    @Autowired
    ModelMapper modelMapper;

    @PutMapping("/depositar")
    public SaidaDTO depositar(@RequestBody EntradaDTO entradaDTO){
        Operacao operacao = modelMapper.map(entradaDTO, Operacao.class);
        SaidaDTO saidaDTO = modelMapper.map(operacaoService.depositar(operacao), SaidaDTO.class);

        return saidaDTO;
    }
}
