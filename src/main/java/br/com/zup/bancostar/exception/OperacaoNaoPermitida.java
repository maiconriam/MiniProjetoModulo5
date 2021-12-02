package br.com.zup.bancostar.exception;

public class OperacaoNaoPermitida extends RuntimeException{
    public OperacaoNaoPermitida(String message) {
        super(message);
    }
}
