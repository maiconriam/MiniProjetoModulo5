package br.com.zup.bancostar.conta.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@NoArgsConstructor
@Getter
@Setter

public class ContaComUsuarioDTO {
    @CPF
    private String usuarioId;
    private Integer contaId;


}
