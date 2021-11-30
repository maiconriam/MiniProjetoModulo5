package br.com.zup.bancostar.conta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

public class ContaSaidaDTO {

    @NotBlank
    private String banco;
    @NotNull
    private Double valor;
    @NotBlank
    private LocalDate dataCriacaoConta;
}
