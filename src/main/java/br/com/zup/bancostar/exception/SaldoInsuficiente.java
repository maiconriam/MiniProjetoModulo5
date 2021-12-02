package br.com.zup.bancostar.exception;

public class SaldoInsuficiente extends RuntimeException{
    public SaldoInsuficiente(String message) {
        super(message);
    }
}
