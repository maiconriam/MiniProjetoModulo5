package br.com.zup.bancostar.exception;

public class UsuarioNaoEncontrado extends RuntimeException {

    public UsuarioNaoEncontrado(String message) {
        super(message);
    }
}
