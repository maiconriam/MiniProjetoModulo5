package br.com.zup.bancostar.config;

import br.com.zup.bancostar.exception.CpfJaCadastrado;
import br.com.zup.bancostar.exception.EmailJaCadastrado;
import br.com.zup.bancostar.exception.UsuarioNaoEncontrado;
import br.com.zup.bancostar.exception.UsuarioStatusDesativado;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroDeValidacao> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<ErroDeValidacao> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            ErroDeValidacao erroDeValidacao = new ErroDeValidacao(fieldError.getField(),
                    fieldError.getDefaultMessage());
            erros.add(erroDeValidacao);
        }

        return erros;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroDeValidacao manipularErrosDeValidacao() {
        return new ErroDeValidacao("Tipo", "Opções: PF ou PJ");
    }

    @ExceptionHandler(EmailJaCadastrado.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public MensagemDeErro manipularErrosDeDuplicidade(EmailJaCadastrado emailJaCadastrado) {
        return new MensagemDeErro(emailJaCadastrado.getMessage());
    }

    @ExceptionHandler(CpfJaCadastrado.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public MensagemDeErro manipularErrosDeDuplicidade(CpfJaCadastrado cpfJaCadastrado) {
        return new MensagemDeErro(cpfJaCadastrado.getMessage());
    }

    @ExceptionHandler(UsuarioNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularErroDeUsuarioNaoEncontrado(UsuarioNaoEncontrado usuarioNaoEncontrado) {
        return new MensagemDeErro(usuarioNaoEncontrado.getMessage());
    }

    @ExceptionHandler(UsuarioStatusDesativado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularErroDeUsuarioNaoEncontrado(UsuarioStatusDesativado usuarioStatusDesativado) {
        return new MensagemDeErro(usuarioStatusDesativado.getMessage());
    }
}
