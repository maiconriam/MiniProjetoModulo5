package br.com.zup.bancostar.conta.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ContaSaidaDTO {

    @NotNull(message = "{validacao.obrigatorio}")
    private String banco;
    private double valor;
<<<<<<< HEAD:src/main/java/br/com/zup/bancostar/dtos/ContaSaidaDTO.java
    @NotBlank
=======
>>>>>>> 15fb406 (Retirar Wrapper do atributo valor.):src/main/java/br/com/zup/bancostar/conta/dtos/ContaSaidaDTO.java
    private LocalDate dataCriacaoConta;
}
