package br.com.consulvet.apis.domain.exception;

public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ForbiddenException(String mensagem){
        super(mensagem);
    }
}