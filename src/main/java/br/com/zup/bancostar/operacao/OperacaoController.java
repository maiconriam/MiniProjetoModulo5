package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.operacao.dto.EntradaDTO;
import br.com.zup.bancostar.operacao.dto.SaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {
    @Autowired
    private OperacaoService operacaoService;
    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @PostMapping("/depositar")
    public SaidaDTO depositar (@RequestBody EntradaDTO entradaDTO){
        modelMapper.typeMap(Operacao.class, SaidaDTO.class).addMappings(modelMapper -> modelMapper.map(
                operacao -> operacao.getConta().getId(),SaidaDTO::setConta));
        Operacao operacao = modelMapper.map(entradaDTO, Operacao.class);
        SaidaDTO saidaDTO = modelMapper.map(operacaoService.depositar(operacao, entradaDTO.getConta()),
                SaidaDTO.class);

        return saidaDTO;
    }

    @Transactional
    @PostMapping("/sacar")
    public SaidaDTO sacar (@RequestBody EntradaDTO entradaDTO){
        modelMapper.typeMap(Operacao.class, SaidaDTO.class).addMappings(modelMapper -> modelMapper.map(
                operacao -> operacao.getConta().getId(),SaidaDTO::setConta));
        Operacao operacao = modelMapper.map(entradaDTO, Operacao.class);
        SaidaDTO saidaDTO = modelMapper.map(operacaoService.depositar(operacao, entradaDTO.getConta()),
                SaidaDTO.class);

        return saidaDTO;
    }

}
