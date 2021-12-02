package br.com.zup.bancostar.extrato;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.operacao.Operacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "extrato")
@NoArgsConstructor
@Getter
@Setter
public class Extrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private double saldo;
    @ManyToOne
    private Conta conta;
    @ManyToOne
    private Operacao operacaos;

}
