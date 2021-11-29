package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.operacao.dtos.DepositarDTO;
import br.com.zup.bancostar.operacao.dtos.SaidaDepositarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    OperacaoService operacaoService;

    @Autowired
    ModelMapper modelMapper;

    @PutMapping("/depositar")
    public SaidaDepositarDTO depositar (@RequestBody DepositarDTO depositarDTO){
        Operacao operacao = modelMapper.map(depositarDTO, Operacao.class);
        SaidaDepositarDTO saidaDepositarDTO = modelMapper.map(operacaoService.depositar(operacao),
                SaidaDepositarDTO.class);

        return saidaDepositarDTO;
    }
}
