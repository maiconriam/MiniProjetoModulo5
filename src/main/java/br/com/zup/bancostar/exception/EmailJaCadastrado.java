package br.com.zup.bancostar.exception;

public class EmailJaCadastrado extends RuntimeException {
    public EmailJaCadastrado(String message) {
        super(message);
    }
}
