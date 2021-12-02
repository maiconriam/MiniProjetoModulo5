package br.com.zup.bancostar.exception;

public class ContaDesativada extends RuntimeException{
    public ContaDesativada(String message) {
        super(message);
    }
}
