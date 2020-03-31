package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

public class BotoesPadrao {

    Font fonte = new Font("Arial", Font.BOLD, 15);
    JFrame caixaAvisoMsg = new JFrame();
    JPanel painelcaixaAviso = new JPanel();

    Color cor;

    public BotoesPadrao() {
    }

    public JButton montaBtnPadrao() {
        JButton btnPadrao = new JButton();
        btnPadrao.setBackground(new Color(138, 43, 226));
        btnPadrao.setBorder(null);
        btnPadrao.setFocusPainted(false);
        btnPadrao.setFont(fonte);
        btnPadrao.setForeground(Color.WHITE);
        return btnPadrao;
    }

    public JButton montaBtnAlteravel() {
        JButton btnPadrao = new JButton();
        btnPadrao.setBorder(null);
        btnPadrao.setFocusPainted(false);
        btnPadrao.setFont(fonte);
        return btnPadrao;
    }

    public Color validaCorCampo(String campo) {
        if (campo.length() <= 0) {
            cor = Color.RED;
        } else {
            cor = Color.GREEN;
        }

        return cor;
    }

    /* public JFrame novaCaixa() {
        
        
    }*/
    public JFrame montaAvisoMensagem(String texto, String tipoAviso) {
        caixaAvisoMsg.setUndecorated(true);
        caixaAvisoMsg.setVisible(true);
        caixaAvisoMsg.setSize(275, 125);
        caixaAvisoMsg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        caixaAvisoMsg.setLocationRelativeTo(null);

        painelcaixaAviso.setSize(275, 125);
        painelcaixaAviso.setBackground(corTipoAviso(tipoAviso));
        painelcaixaAviso.setLayout(null);

        JLabel txtLblCaixaAviso = new JLabel(texto);
        txtLblCaixaAviso.setForeground(Color.WHITE);
        txtLblCaixaAviso.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblCaixaAviso.setBounds(5, 30, 300, 25);
        
        
        JLabel btnOkay = new JLabel("OK");
        btnOkay.setForeground(Color.WHITE);
        btnOkay.setFont(new Font("Arial", Font.BOLD, 20));
        btnOkay.setBounds(120, 80, 100, 25);
        btnOkay.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                caixaAvisoMsg.dispose();
            }
        });

        
        painelcaixaAviso.add(btnOkay);
        painelcaixaAviso.add(txtLblCaixaAviso);

        caixaAvisoMsg.add(painelcaixaAviso);

        return caixaAvisoMsg;

    }

    public Color corTipoAviso(String TipoAviso) {
        Color corAviso = null;

        switch (TipoAviso) {
            case "SUCESSO":
                corAviso = new Color(0, 255, 127);
                break;
            case "AVISO":
                corAviso = new Color(255, 215, 0);
                break;
            case "ERRO":
                corAviso = new Color(255, 99, 71);
                break;
        }

        return corAviso;
    }

   

}
