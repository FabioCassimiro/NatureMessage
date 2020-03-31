package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigConexaoServidor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TelaServidor {
    
    PainelPadrao painelServidor = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    JFrame telaServidor = new JFrame();

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

        JButton btnEntra = new JButton();
        btnEntra = botoesPadrao.montaBtnAlteravel();
        btnEntra.setText("Entrar");
        btnEntra.setBounds(277, 268, 350, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        btnEntra.setForeground(Color.WHITE);
        btnEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigConexaoServidor servidor = new ConfigConexaoServidor();
                servidor.ValidaServidor(txfUsuario.getText());
                telaServidor.dispose();
                new TelaChat();
                botoesPadrao.montaAvisoMensagem("Conectado a: " +servidor.getNoHostname(), "SUCESSO");
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
