package br.com.zup.bancostar.conta.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@Getter
@Setter

public class ContaComUsuarioDTO {
    @CPF
    @NotNull(message = "{validacao.obrigatorio}")
    private String usuarioId;
    @NotNull(message = "{validacao.obrigatorio}")
    @Positive(message = "{validacao.valor.positivo}")
    private Integer contaId;


}
