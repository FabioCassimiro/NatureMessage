package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaSobre {

    PainelPadrao painelSobre = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    JFrame telaSobre = new JFrame();
    
    Font fonte = new Font("Arial", Font.BOLD, 15);

    public TelaSobre() {
        telaSobre.add(montaPainelSobre());
        telaSobre.setSize(900, 500);
        telaSobre.setLocationRelativeTo(null);
        telaSobre.setUndecorated(true);
        telaSobre.setVisible(true);
    }

    public JPanel montaPainelSobre() {
        
        JLabel txtLblTexto = new JLabel("SOBRE");
        txtLblTexto.setForeground(Color.WHITE);
        txtLblTexto.setFont(new Font("Arial", Font.BOLD, 25));
        txtLblTexto.setBounds(400, 50, 350, 100);
        
        /*JLabel txtLblTexto = new JLabel("Nome:");
        txtLblTexto.setForeground(Color.WHITE);
        txtLblTexto.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblTexto.setBounds(29, 33, 350, 32);*/
        
        painelSobre.add(txtLblTexto);
        
        return painelSobre;
    }
}
