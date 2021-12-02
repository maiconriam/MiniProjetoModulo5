package br.com.zup.bancostar.extrato;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {

    @Autowired
    private ExtratoService extratoService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{id}")
    public Extrato exibirExtrato(@PathVariable Integer id){

        return extratoService.exibirExtrato(id);
    }
}