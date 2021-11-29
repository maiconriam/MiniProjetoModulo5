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

public class ContaDTO {
    @NotNull
    private Integer id;
    @NotBlank
    private String banco;
    @NotNull
    private Double saldo;
    @NotBlank
    private LocalDate dataCriacaoConta;

}
