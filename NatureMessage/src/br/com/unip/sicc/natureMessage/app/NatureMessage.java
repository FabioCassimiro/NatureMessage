package br.com.unip.sicc.natureMessage.app;

import br.com.unip.sicc.natureMessage.control.ConfigConexaoServidor;
import br.com.unip.sicc.natureMessage.viewer.TelaCadastro;
import br.com.unip.sicc.natureMessage.viewer.TelaChat;
import br.com.unip.sicc.natureMessage.viewer.TelaServidor;
import br.com.unip.sicc.natureMessage.viewer.TelaConexao;
import br.com.unip.sicc.natureMessage.viewer.TelaLogin;



public class NatureMessage {

    public static void main(String[] args) {
        new TelaCadastro();
                
       // new TelaChat();
       // ConfigConexaoServidor  chat = new ConfigConexaoServidor();
       // chat.conexaoChat("127.0.0.1",5000);

    }
}
