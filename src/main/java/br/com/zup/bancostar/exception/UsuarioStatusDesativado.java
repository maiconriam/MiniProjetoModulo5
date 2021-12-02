package br.com.zup.bancostar.exception;

public class UsuarioStatusDesativado extends RuntimeException {
    public UsuarioStatusDesativado(String message) {
        super(message);
    }
}
