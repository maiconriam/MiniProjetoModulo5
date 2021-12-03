package br.com.zup.bancostar.usuario.dtos;

import br.com.zup.bancostar.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioAtualizadoDTO {
    @Size(min = 4, max = 100, message = "{validacao.nome.size}")
    @NotBlank(message = "{validacao.obrigatorio}")
    private String nome;
    @Email
    @NotBlank(message = "{validacao.obrigatorio}")
    private String email;
    @NotBlank(message = "{validacao.obrigatorio}")
    private String telefone;
    @NotNull(message = "{validacao.obrigatorio}")
    private Tipo tipo;
}
