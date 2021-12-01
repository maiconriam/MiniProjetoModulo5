package br.com.zup.bancostar.usuario.dtos;

import br.com.zup.bancostar.enuns.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
public class UsuarioSaidaDTO {
    @CPF
    private String cpf;
    @Size(min = 4, max = 100, message = "{validacao.nome.size}")
    @NotBlank(message = "{validacao.obrigatorio}")
    private String nome;
    @Email
    @NotBlank(message = "{validacao.obrigatorio}")
    private String email;
    @NotBlank(message = "{validacao.obrigatorio}")
    private String telefone;
    private String tipoPessoa;
    private Status status;

}
