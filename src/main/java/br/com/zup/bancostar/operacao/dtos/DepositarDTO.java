package br.com.zup.bancostar.operacao.dtos;

import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DepositarDTO {
    private TipoOperacao tipoOperacao;
    private Double valor;
    private Integer contaParaDeposito;
}
