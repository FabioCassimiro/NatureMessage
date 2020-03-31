package br.com.unip.sicc.natureMessage.exception;

public class PasswordsDontMatch extends Exception {

    public PasswordsDontMatch() {
    }

    public PasswordsDontMatch(String msg) {
        super(msg);
    }
}
