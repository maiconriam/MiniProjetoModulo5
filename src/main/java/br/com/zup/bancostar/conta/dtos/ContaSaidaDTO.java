package br.com.zup.bancostar.conta.dtos;

import br.com.zup.bancostar.usuario.Usuario;
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

    @NotNull(message = "{validacao.obrigatorio}")
    private String banco;
    private double valor;
    @NotBlank
    private LocalDate dataCriacaoConta;
    private Usuario usuario;

}
