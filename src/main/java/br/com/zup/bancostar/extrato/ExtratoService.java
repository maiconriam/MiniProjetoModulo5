package br.com.zup.bancostar.extrato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoService {

    @Autowired
    private ExtratoRepository extratoRepository;
}