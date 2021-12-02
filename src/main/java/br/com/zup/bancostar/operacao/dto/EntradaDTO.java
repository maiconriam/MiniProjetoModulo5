package br.com.zup.bancostar.operacao.dto;

import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EntradaDTO {
    private TipoOperacao tipoOperacao;
    private double valor;
    private Integer conta;
    private Integer contaDestino;
}
