package br.com.zup.bancostar.operacao.dtos;

import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class SaidaDTO {
    private TipoOperacao tipoOperacao;
    private Double valor;
    private LocalDate dataDaOperacao;
    private Integer contaDeOrigem;
    private Integer contaDeDestino;

}
