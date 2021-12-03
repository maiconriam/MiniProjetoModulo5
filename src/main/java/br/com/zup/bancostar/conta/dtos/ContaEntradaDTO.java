package br.com.zup.bancostar.conta.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter

public class ContaEntradaDTO {

    @NotNull(message = "{validacao.obrigatorio}")
    @Size(min = 4, max = 100, message = "{validacao.nome.size}")
    private String banco;
    @NotNull(message = "{validacao.obrigatorio}")
    @Positive(message = "{validacao.valor.positivo}")
    private double valor;


}
