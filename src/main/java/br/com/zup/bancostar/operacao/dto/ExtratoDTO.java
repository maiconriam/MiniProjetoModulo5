package br.com.zup.bancostar.operacao.dto;

import br.com.zup.bancostar.enuns.TipoOperacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ExtratoDTO {
    private double saldo;
    private List<ExtratoDataDTO> operacoes = new ArrayList<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExtratoDataDTO{
        private TipoOperacao tipoOperacao;
        private double valor;
        private LocalDateTime dataHoraOperacao;
    }

}
