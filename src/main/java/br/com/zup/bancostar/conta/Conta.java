package br.com.zup.bancostar.conta;

import br.com.zup.bancostar.usuario.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "conta")
@NoArgsConstructor
@Getter
@Setter
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String banco;
    private Double valor = 0.0;
    private LocalDate dataDeCriacao;
    @OneToOne
    private Usuario usuario;
}