
package br.com.unip.sicc.natureMessage.exception;

public class ServerDownException extends Exception {
    public ServerDownException(){
        
    }

    public ServerDownException(String msg) {
        super(msg);
    }
}
