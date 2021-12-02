package br.com.zup.bancostar.extrato.dtos;

import br.com.zup.bancostar.extrato.Extrato;
import br.com.zup.bancostar.operacao.Operacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ExtratoSaidaDTO {
    private List<ExtratoDTO> extratos;
}
