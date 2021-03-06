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
    @Column(nullable = false)
    private String banco;
    @Column(nullable = false)
    private double saldo;
    private LocalDate dataDeCriacao;
    @OneToOne
    private Usuario usuario;
}