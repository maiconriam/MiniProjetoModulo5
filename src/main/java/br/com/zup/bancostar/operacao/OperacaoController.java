package br.com.zup.bancostar.operacao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacaoController {

    @Autowired
    OperacaoService operacaoService;

    @Autowired
    ModelMapper modelMapper;
}