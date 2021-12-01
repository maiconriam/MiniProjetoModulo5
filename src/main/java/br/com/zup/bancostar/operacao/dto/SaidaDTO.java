package br.com.zup.bancostar.operacao.dto;

import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
public class SaidaDTO {
    private TipoOperacao tipoOperacao;
    private double valor;
    private LocalDateTime dataHoraOperacao;
    private Integer conta;
}
