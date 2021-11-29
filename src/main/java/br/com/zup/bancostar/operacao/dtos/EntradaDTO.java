package br.com.zup.bancostar.operacao.dtos;

import br.com.zup.bancostar.enuns.TipoOperacao;


public class EntradaDTO {
    private TipoOperacao tipoOperacao;
    private Double valor;
    private Integer contaDeOrigem;
    private Integer contaDeDestino;

    public EntradaDTO() {

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
