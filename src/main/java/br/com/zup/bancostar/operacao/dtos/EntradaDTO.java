package br.com.zup.bancostar.operacao.dtos;

import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EntradaDTO {
    private TipoOperacao tipoOperacao;
    private Double valor;
    private Integer contaDeOrigem;
    private Integer contaDeDestino;

}
