package br.com.unip.sicc.natureMessage.exception;

public class InsufficientCharactersException extends Exception {

    public InsufficientCharactersException() {
    }

    public InsufficientCharactersException(String msg) {
        super(msg);
    }
}
