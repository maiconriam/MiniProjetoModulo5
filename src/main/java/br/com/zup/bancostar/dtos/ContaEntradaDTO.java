package br.com.zup.bancostar.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

public class ContaEntradaDTO {

    @NotBlank
    private String banco;
    @NotNull
    private double valor;


}
