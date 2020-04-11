package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class TelaInicial {

    PainelPadrao painelInicial = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    JFrame telaInicial = new JFrame();
    
    public JLabel lblLogo;

    public JButton btnInicia;
    
    ImageIcon imagemCompartilhar = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/logo.png"));
    JLabel mostraCompartilhar = new JLabel(imagemCompartilhar);


    public TelaInicial() {
        
        telaInicial.setSize(900, 500);
        telaInicial.add(montaPainelInicial());
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
    }

    public JPanel montaPainelInicial() {
        
        lblLogo = new JLabel();
        lblLogo.setBounds(340, 140, 250, 250);
        lblLogo.setBorder(null);
        lblLogo.setBackground(null);
        lblLogo.setForeground(null);
        //btnLogo.setContentAreaFilled(false);
        lblLogo.setIcon(imagemCompartilhar);

        JLabel txtLblTitulo = new JLabel("NATURE");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        txtLblTitulo.setBounds(378, 100, 350, 32);

        JLabel txtLblSubTitulo = new JLabel("MESSAGE");
        txtLblSubTitulo.setForeground(Color.WHITE);
        txtLblSubTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        txtLblSubTitulo.setBounds(396, 124, 350, 32);

        btnInicia = new JButton();
        btnInicia = botoesPadrao.montaBtnAlteravel();
        btnInicia.setText("Iniciar");
        btnInicia.setBounds(277, 342, 350, 30);
        btnInicia.setBackground(new Color(0, 255, 127));
        btnInicia.setForeground(Color.WHITE);
        btnInicia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaInicial.dispose();
                new TelaLogin();
            }
        });
        
        JButton btnManual = new JButton();
        btnManual = botoesPadrao.montaBtnPadrao();
        btnManual.setText("Manual de funcionamento");
        btnManual.setForeground(Color.WHITE);
        btnManual.setFont(new Font("Arial", Font.BOLD, 12));
        btnManual.setBounds(378, 377, 150, 35);
        btnManual.setContentAreaFilled(false);
        btnManual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JSeparator linhaSeparatorManual = new JSeparator();
        linhaSeparatorManual.setForeground(Color.WHITE);
        linhaSeparatorManual.setBounds(352, 380, 200, 1);

        painelInicial.add(btnInicia);
        painelInicial.add(txtLblTitulo);
        painelInicial.add(txtLblSubTitulo);
        painelInicial.add(btnManual);
        painelInicial.add(linhaSeparatorManual);
        painelInicial.add(lblLogo);

        return painelInicial;
    }

}
