
package br.com.unip.sicc.natureMessage.exception;

public class ServerNotFoundException extends Exception {
    
    public ServerNotFoundException(){
        
    }

    public ServerNotFoundException(String msg) {
        super(msg);
    }
}
