package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigChat;
import br.com.unip.sicc.natureMessage.control.ConfigConexaoServidor;
import br.com.unip.sicc.natureMessage.exception.ServerNotFoundException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TelaServidor {

    private PainelPadrao pnlServidor = new PainelPadrao();
    private Componentes componente = new Componentes();
    private JFrame telaServidor = new JFrame();
    private JTextField txfEnderecoIP;

    public TelaServidor() {
        telaServidor.add(montaPainelServidor());
        telaServidor.setSize(900, 500);
        telaServidor.setLocationRelativeTo(null);
        telaServidor.setUndecorated(true);
        telaServidor.setVisible(true);
    }

    public JPanel montaPainelServidor() {

        pnlServidor.add(Componentes.montaBtnMinimizar(telaServidor));
        pnlServidor.add(Componentes.montaTexto("Servidor", 35, Color.white, 361, 100, 350, 32));
        pnlServidor.add(Componentes.montaTexto("Informe o codigo do servidor:", 12, Color.white, 277, 202, 350, 25));
        txfEnderecoIP = Componentes.montaTxfPadrao(277, 225, 350, 30);
        pnlServidor.add(Componentes.montaSeparadora(277, 255, 350, 1));

        JButton btnEntra = componente.montaBotaoAlteravel("Entrar");
        btnEntra.setBounds(277, 268, 350, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        Action actionTecla = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnEntra.doClick();
            }
        };
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        InputMap inputMap = btnEntra.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "Tecla_Enter");
        ActionMap actionMap = btnEntra.getActionMap();
        actionMap.put("Tecla_Enter", actionTecla);
        btnEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ConfigConexaoServidor servidor = new ConfigConexaoServidor();
                    servidor.ValidaServidor(txfEnderecoIP.getText().toUpperCase());
                    telaServidor.dispose();
                    new TelaChat(servidor.getPortaServidor());
                    String mensagemStatus = ConfigChat.status.equals("Online")? "Conectado a: " + servidor.getNomeServidor() :"Servidor: " + servidor.getNomeServidor() + " Offline\n"
                            + "Somente as mensagens foram carregadas" ;
                    JOptionPane.showMessageDialog(null,mensagemStatus,"Mensagem servidor",ConfigChat.status.equals("Online")?JOptionPane.INFORMATION_MESSAGE:JOptionPane.ERROR_MESSAGE);
                } catch (ServerNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });

        pnlServidor.add(txfEnderecoIP);
        pnlServidor.add(btnEntra);

        return pnlServidor;
    }
}
