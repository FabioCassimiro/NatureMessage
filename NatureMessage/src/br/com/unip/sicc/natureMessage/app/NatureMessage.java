package br.com.unip.sicc.natureMessage.app;

import br.com.unip.sicc.natureMessage.control.ConfigRelatorio;
import br.com.unip.sicc.natureMessage.viewer.Componentes;
import br.com.unip.sicc.natureMessage.viewer.TelaChat;
import br.com.unip.sicc.natureMessage.viewer.TelaConsultaRelatorio;
import br.com.unip.sicc.natureMessage.viewer.TelaInicial;
import br.com.unip.sicc.natureMessage.viewer.TelaLogin;
import br.com.unip.sicc.natureMessage.viewer.TelaServidor;
import br.com.unip.sicc.natureMessage.viewer.TelaSobre;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class NatureMessage {

    public static void main(String[] args) {
        //new TelaServidor();
        new TelaLogin();
       //new TelaChat(5000);
        //new TelaConsultaRelatorio();
        //new TelaSobre();
       //new TelaInicial();
        //System.out.println(Componentes.dataHoraAtual());
    }
}
