package br.com.unip.sicc.natureMessage.app;

import br.com.unip.sicc.natureMessage.viewer.Componentes;
import br.com.unip.sicc.natureMessage.viewer.TelaCadastro;
import br.com.unip.sicc.natureMessage.viewer.TelaChat;
import br.com.unip.sicc.natureMessage.viewer.TelaLogin;
import br.com.unip.sicc.natureMessage.viewer.TelaServidor;
import br.com.unip.sicc.natureMessage.viewer.TelaSobre;

public class NatureMessage {

    public static void main(String[] args) {
        //new TelaServidor();
        new TelaChat(5000);
        //new TelaLogin();
       //new TelaCadastro();
       //new TelaSobre();
    }
}
