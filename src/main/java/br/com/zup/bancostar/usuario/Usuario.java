package br.com.zup.bancostar.usuario;

import br.com.zup.bancostar.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private Tipo tipo;
}
