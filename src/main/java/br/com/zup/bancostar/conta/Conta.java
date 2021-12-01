package br.com.zup.bancostar.conta;

import br.com.zup.bancostar.extrato.Extrato;
import br.com.zup.bancostar.usuario.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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
    private double valor;
    private LocalDate dataDeCriacao;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Extrato> extrato;
}