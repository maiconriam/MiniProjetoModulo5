package br.com.zup.bancostar.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoRepository operacaoRepository;
}
