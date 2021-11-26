package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.conta.Conta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "name")
@NoArgsConstructor
@Getter
@Setter
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TipoOperacao tipoOperacao;
    private Double valor;
    private LocalDate dataDaOperacao;
    @OneToOne
    private Conta contaDeOrigem;
    @OneToOne
    private Conta contaDeDestino;
}
