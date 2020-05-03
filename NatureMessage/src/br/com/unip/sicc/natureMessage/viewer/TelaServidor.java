package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigConexaoServidor;
import br.com.unip.sicc.natureMessage.exception.ServerNotFoundException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TelaServidor {

    private PainelPadrao pnlServidor = new PainelPadrao();
    private Componentes componente = new Componentes();
    private String nomeUsuario;
    private JLabel lblTitulo;
    private JButton btnEntra;
    private JFrame telaServidor = new JFrame();
    private JTextField txfEnderecoIP;
    private JLabel lblEnderecoIP;
    private JSeparator lnsUsuario;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public TelaServidor() {
        telaServidor.add(montaPainelServidor());
        telaServidor.setSize(900, 500);
        telaServidor.setLocationRelativeTo(null);
        telaServidor.setUndecorated(true);
        telaServidor.setVisible(true);
    }

    public JPanel montaPainelServidor() {

        lblTitulo = new JLabel("SERVIDOR");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        lblTitulo.setBounds(361, 100, 350, 32);

        txfEnderecoIP = new JTextField();
        txfEnderecoIP.setBorder(null);
        txfEnderecoIP.setForeground(Color.WHITE);
        txfEnderecoIP.setBackground(null);
        txfEnderecoIP.setBounds(277, 225, 350, 30);

        lblEnderecoIP = new JLabel("Informe endereço IP:");
        lblEnderecoIP.setForeground(Color.WHITE);
        lblEnderecoIP.setFont(new Font("Arial", Font.BOLD, 12));
        lblEnderecoIP.setBounds(277, 202, 350, 25);

        lnsUsuario = new JSeparator();
        lnsUsuario.setForeground(Color.WHITE);
        lnsUsuario.setBounds(277, 255, 350, 1);

        btnEntra = componente.montaBtnAlteravel("Entrar");
        btnEntra.setBounds(277, 268, 350, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        btnEntra.setForeground(Color.WHITE);
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
                    TelaChat telaChat = new TelaChat(servidor.getPortaServidor());
                    telaChat.setNomeUsuario(nomeUsuario);
                    componente.montaAvisoMensagem(nomeUsuario + " Conectado a: " + servidor.getNomeServidor(), "SUCESSO");
                } catch (ServerNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });

        pnlServidor.add(lblTitulo);
        pnlServidor.add(txfEnderecoIP);
        pnlServidor.add(lblEnderecoIP);
        pnlServidor.add(lnsUsuario);
        pnlServidor.add(btnEntra);

        return pnlServidor;
    }
}
