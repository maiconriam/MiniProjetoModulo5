package br.com.zup.bancostar.operacao;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.enuns.TipoOperacao;
import br.com.zup.bancostar.extrato.Extrato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "operacao")
@NoArgsConstructor
@Getter
@Setter
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TipoOperacao tipoOperacao;
    private double valor;
    private LocalDateTime dataHoraOperacao;
    @ManyToOne
    private Conta conta;
}
