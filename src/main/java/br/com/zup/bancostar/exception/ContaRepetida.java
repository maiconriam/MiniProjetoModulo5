package br.com.zup.bancostar.exception;

public class ContaRepetida extends RuntimeException{
    public ContaRepetida(String message){
        super(message);
    }
}
