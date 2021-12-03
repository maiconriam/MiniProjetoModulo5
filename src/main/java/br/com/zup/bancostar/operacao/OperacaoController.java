package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.operacao.dto.EntradaDTO;
import br.com.zup.bancostar.operacao.dto.ExtratoDTO;
import br.com.zup.bancostar.operacao.dto.SaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {
    @Autowired
    private OperacaoService operacaoService;
    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @PostMapping
    public SaidaDTO registrarOperacao (@RequestBody @Valid EntradaDTO entradaDTO){
        modelMapper.typeMap(Operacao.class, SaidaDTO.class).addMappings(modelMapper -> modelMapper.map(
                operacao -> operacao.getConta().getId(),SaidaDTO::setConta));
        SaidaDTO saidaDTO = modelMapper.map(operacaoService.registrarOperacao(entradaDTO.getTipoOperacao(), entradaDTO.getValor(),
                        entradaDTO.getConta(), entradaDTO.getContaDestino()),
                SaidaDTO.class);

        return saidaDTO;
    }

    @GetMapping
    public ExtratoDTO extrato(@RequestParam(name = "idConta") Integer id){
        return operacaoService.extrato(id);
    }
}
