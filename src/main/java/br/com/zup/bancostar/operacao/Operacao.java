package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operacao")
@NoArgsConstructor
@Getter
@Setter
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;
    @Column(nullable = false)
    private double valor;
    private LocalDateTime dataHoraOperacao;
    @ManyToOne
    private Conta conta;
}
