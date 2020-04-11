package br.com.unip.sicc.natureMessage.viewer;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicArrowButton;

public class BotoesPadrao {

    Font fonte = new Font("Arial", Font.BOLD, 15);
    JFrame caixaAvisoMsg = new JFrame();
    JPanel painelcaixaAviso = new JPanel();
    JButton btnOkay;

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
        
        btnOkay = new JButton("OK");
        btnOkay.setForeground(Color.WHITE);
        btnOkay.setFont(new Font("Arial", Font.BOLD, 20));
        btnOkay.setBounds(120, 80, 100, 25);
        btnOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caixaAvisoMsg.dispose();
            }
        });
        Action actionTecla = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //simula o click no botão
                btnOkay.doClick();

            }
        };
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        InputMap inputMap = btnOkay.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "Tecla_Enter");
        ActionMap actionMap = btnOkay.getActionMap();
        actionMap.put("Tecla_Enter", actionTecla);

        
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
