package br.com.zup.bancostar.operacao.dto;

import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@Getter
@Setter
public class EntradaDTO {
    @NotNull(message = "{validacao.obrigatorio}")
    private TipoOperacao tipoOperacao;
    @NotNull(message = "{validacao.obrigatorio}")
    @Positive(message = "{validacao.valor.positivo}")
    private double valor;
    @NotNull(message = "{validacao.obrigatorio}")
    @Positive(message = "{validacao.valor.positivo}")
    private Integer conta;
    @Positive(message = "{validacao.valor.positivo}")
    private Integer contaDestino;
}
