package br.com.zup.bancostar.exception;

public class ContaNaoEncontrada extends RuntimeException{
    public ContaNaoEncontrada(String message) {
        super(message);
    }
}
