package br.com.zup.bancostar.exception;

public class CpfJaCadastrado extends RuntimeException{
    public CpfJaCadastrado(String message){
        super(message);
    }
}
