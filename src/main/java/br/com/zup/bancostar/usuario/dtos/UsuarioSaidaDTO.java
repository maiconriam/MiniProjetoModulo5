package br.com.zup.bancostar.usuario.dtos;

import br.com.zup.bancostar.enuns.Status;
import br.com.zup.bancostar.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
public class UsuarioSaidaDTO {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String tipoPessoa;
    private Status status;

}
