package br.com.zup.bancostar.extrato.dtos;

import br.com.zup.bancostar.conta.Conta;
import br.com.zup.bancostar.enuns.TipoOperacao;
import br.com.zup.bancostar.operacao.Operacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ExtratoDTO {
    private LocalDateTime dataHoraOperacao;
    private TipoOperacao tipoOperacao;
    private double valor;
    private double saldo;
}