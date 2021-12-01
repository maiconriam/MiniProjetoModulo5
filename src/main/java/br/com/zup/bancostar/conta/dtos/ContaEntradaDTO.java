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
<<<<<<< HEAD:src/main/java/br/com/zup/bancostar/dtos/ContaEntradaDTO.java
    @NotNull
=======
>>>>>>> 15fb406 (Retirar Wrapper do atributo valor.):src/main/java/br/com/zup/bancostar/conta/dtos/ContaEntradaDTO.java
    private double valor;


}
