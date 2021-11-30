package br.com.zup.bancostar.usuario;

import br.com.zup.bancostar.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    private String cpf;
    @Size(min = 4, max = 100, message = "{validacao.nome.size}")
    private String nome;
    @Column(unique = true)
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
