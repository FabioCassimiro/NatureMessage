package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigConexaoServidor;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TelaServidor {
    
    PainelPadrao painelServidor = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    private String nomeUsuario;
    JButton btnEntra;
    JFrame telaServidor = new JFrame();

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

        JLabel txtLblTitulo = new JLabel("SERVIDOR");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        txtLblTitulo.setBounds(361, 100, 350, 32);

        JTextField txfUsuario = new JTextField();
        txfUsuario.setBorder(null);
        txfUsuario.setForeground(Color.WHITE);
        txfUsuario.setBackground(null);
        txfUsuario.setBounds(277, 225, 350, 30);

        JLabel txtLblSubUsuario = new JLabel("Informe endereço IP:");
        txtLblSubUsuario.setForeground(Color.WHITE);
        txtLblSubUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblSubUsuario.setBounds(277, 202, 350, 25);

        JSeparator linhaSeparatorUsuario = new JSeparator();
        linhaSeparatorUsuario.setForeground(Color.WHITE);
        linhaSeparatorUsuario.setBounds(277, 255, 350, 1);

        btnEntra = new JButton();
        btnEntra = botoesPadrao.montaBtnAlteravel();
        btnEntra.setText("Entrar");
        btnEntra.setBounds(277, 268, 350, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        btnEntra.setForeground(Color.WHITE);
        Action actionTecla = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //simula o click no botão
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
                ConfigConexaoServidor servidor = new ConfigConexaoServidor();
                servidor.ValidaServidor(txfUsuario.getText());
                telaServidor.dispose();
                TelaChat telaChat =  new TelaChat();
                telaChat.setNomeUsuario(nomeUsuario);
                botoesPadrao.montaAvisoMensagem(nomeUsuario + " Conectado a: " +servidor.getNoHostname(), "SUCESSO");
            }
        });
         

        painelServidor.add(txtLblTitulo);
        painelServidor.add(txfUsuario);
        painelServidor.add(txtLblSubUsuario);
        painelServidor.add(linhaSeparatorUsuario);
        painelServidor.add(btnEntra);

        return painelServidor;

    }

}
