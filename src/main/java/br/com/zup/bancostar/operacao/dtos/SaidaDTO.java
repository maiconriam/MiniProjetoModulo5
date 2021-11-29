package br.com.zup.bancostar.operacao.dtos;

import br.com.zup.bancostar.enuns.TipoOperacao;

import java.time.LocalDate;

public class SaidaDTO {
    private TipoOperacao tipoOperacao;
    private Double valor;
    private LocalDate dataDaOperacao;
    private Integer contaDeOrigem;
    private Integer contaDeDestino;

    public SaidaDTO() {

    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataDaOperacao() {
        return dataDaOperacao;
    }

    public void setDataDaOperacao(LocalDate dataDaOperacao) {
        this.dataDaOperacao = dataDaOperacao;
    }

    public Integer getContaDeOrigem() {
        return contaDeOrigem;
    }

    public void setContaDeOrigem(Integer contaDeOrigem) {
        this.contaDeOrigem = contaDeOrigem;
    }

    public Integer getContaDeDestino() {
        return contaDeDestino;
    }

    public void setContaDeDestino(Integer contaDeDestino) {
        this.contaDeDestino = contaDeDestino;
    }
}
