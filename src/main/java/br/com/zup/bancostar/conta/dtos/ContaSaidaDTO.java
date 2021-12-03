package br.com.zup.bancostar.conta.dtos;

import br.com.zup.bancostar.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ContaSaidaDTO {

    private String banco;
    private double saldo;
    private LocalDate dataCriacaoConta;
    private Usuario usuario;

}
