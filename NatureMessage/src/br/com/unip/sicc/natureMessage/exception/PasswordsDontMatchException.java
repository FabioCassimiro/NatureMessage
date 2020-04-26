package br.com.unip.sicc.natureMessage.exception;

public class PasswordsDontMatchException extends Exception {

    public PasswordsDontMatchException() {
    }

    public PasswordsDontMatchException(String msg) {
        super(msg);
    }
}
