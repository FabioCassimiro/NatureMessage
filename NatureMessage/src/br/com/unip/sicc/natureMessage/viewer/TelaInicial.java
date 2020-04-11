package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial {

    PainelPadrao painelInicial = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    JFrame telaInicial = new JFrame();
    
    public JButton btnInicia;
    
    public TelaInicial() {
        telaInicial.add(montaPainelInicial());
        telaInicial.setSize(900, 500);
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
    }
    
    public JPanel montaPainelInicial() {
        
        JLabel txtLblTitulo = new JLabel("NATURE");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        txtLblTitulo.setBounds(380, 100, 350, 32);
        
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
              
        painelInicial.add(btnInicia);
        painelInicial.add(txtLblTitulo);
        painelInicial.add(txtLblSubTitulo);
        
        return painelInicial;
    }

}
