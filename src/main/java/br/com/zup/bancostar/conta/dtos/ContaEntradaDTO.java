package br.com.zup.bancostar.conta.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter

public class ContaEntradaDTO {

    @NotNull(message = "{validacao.obrigatorio}")
    private String banco;
    private double valor;


}
