package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Componentes {
    
    JLabel img = new JLabel();
    JLabel imgBorda = new JLabel();
    JFrame caixaAvisoMsg = new JFrame();
    JPanel painelcaixaAviso = new JPanel();
    JButton btnOkay;
    
    Color cor;

    /* ImageIcon imagemSucesso = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/sucesso.png"));
    ImageIcon imagemAlerta = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/alerta.png"));
    ImageIcon imagemErro = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/erro.png"));
    ImageIcon imagemBorda = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/borda.png"));*/
    public Componentes() {
    }
    
    public static JSeparator linhaSeparadora(int posicao, String lado) {
        JSeparator linha = new JSeparator();
        linha.setForeground(Color.WHITE);
        if (lado.equals("ESQUERDA")) {
            linha.setBounds(30, posicao, 300, 1);
        } else {
            linha.setBounds(570, posicao, 300, 1);
        }
        
        return linha;
    }
    
    public ImageIcon image(String caminho) {
        ImageIcon imagem = new ImageIcon(getClass().getResource(caminho));
        return imagem;
    }
    
    public static JButton btnVoltar(ImageIcon icone, ActionListener acao) {
        JButton voltar = new JButton();
        voltar.setBounds(15, 10, 25, 25);
        voltar.setBorder(null);
        voltar.setBackground(null);
        voltar.setForeground(null);
        voltar.setContentAreaFilled(false);
        voltar.setIcon(icone);
        voltar.addActionListener(acao);
        return voltar;
    }
    
    public static JButton montaBtnPadrao() {
        
        JButton btnPadrao = new JButton();
        btnPadrao.setBorder(null);
        btnPadrao.setBackground(null);
        btnPadrao.setForeground(null);
        btnPadrao.setContentAreaFilled(false);
        btnPadrao.setFocusPainted(false);
        btnPadrao.setFont(new Font("Arial", Font.BOLD, 12));
        btnPadrao.setForeground(Color.WHITE);
        return btnPadrao;
    }
    
    public static JTextField montaTxfPadrao(int posicao, String lado) {
        JTextField txfPadrao = new JTextField();
        txfPadrao.setBorder(null);
        txfPadrao.setForeground(Color.WHITE);
        txfPadrao.setBackground(null);
        if (lado.equals("ESQUERDA")) {
            txfPadrao.setBounds(30, posicao, 300, 25);
        } else {
            txfPadrao.setBounds(570, posicao, 300, 25);
        }
        
        return txfPadrao;
    }
    
    public static JLabel montaLabelPadrao(String conteudo, String lado, int posicao) {
        JLabel lblPadrao = new JLabel(conteudo);
        lblPadrao.setForeground(Color.WHITE);
        lblPadrao.setFont(new Font("Arial", Font.BOLD, 12));
        if (lado.equals("ESQUERDA")) {
            lblPadrao.setBounds(29, posicao, 350, 32);
        } else {
            lblPadrao.setBounds(570, posicao, 350, 32);
        }
        
        return lblPadrao;
    }
    
    public static JButton montaBtnAlteravel() {
        JButton btnPadrao = new JButton();
        btnPadrao.setBorder(null);
        btnPadrao.setFocusPainted(false);
        btnPadrao.setFont(new Font("Arial", Font.BOLD, 15));
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
    
    public Color resetaCorCampo(String campo) {
        cor = Color.WHITE;
        return cor;
    }
    
    public Color validaCorCampoSenha(String campo) {
        if (campo.length() <= 7) {
            cor = Color.RED;
        } else {
            cor = Color.GREEN;
        }
        
        return cor;
    }
    
    public Color validaCorCampoUsuario(String campo) {
        if (campo.length() <= 7) {
            cor = Color.RED;
        } else {
            cor = Color.GREEN;
        }
        
        return cor;
    }
    
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
        txtLblCaixaAviso.setBounds(11, 48, 300, 25);
        
        imgBorda.setIcon(image("/br/com/unip/sicc/natureMessage/image/borda.png"));
        imgBorda.setBounds(0, 0, 275, 125);
        
        btnOkay = new JButton();
        btnOkay = montaBtnAlteravel();//
        btnOkay.setText("OK");
        btnOkay.setFont(new Font("Arial", Font.BOLD, 20));
        btnOkay.setBounds(86, 90, 100, 25);
        btnOkay.setBackground(null);
        btnOkay.setForeground(Color.WHITE);
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
        painelcaixaAviso.add(imgBorda);
        
        caixaAvisoMsg.add(painelcaixaAviso);
        
        return caixaAvisoMsg;
        
    }
    
    public Color corTipoAviso(String TipoAviso) {
        Color corAviso = null;
        img.setBounds(106, 1, 44, 40);
        
        switch (TipoAviso) {
            case "SUCESSO":
                corAviso = new Color(0, 255, 127);
                img.setIcon(image("/br/com/unip/sicc/natureMessage/image/sucesso.png"));
                painelcaixaAviso.add(img);
                break;
            case "AVISO":
                corAviso = new Color(255, 215, 0);
                img.setIcon(image("/br/com/unip/sicc/natureMessage/image/alerta.png"));
                painelcaixaAviso.add(img);
                break;
            case "ERRO":
                corAviso = new Color(255, 99, 71);
                img.setIcon(image("/br/com/unip/sicc/natureMessage/image/erro.png"));
                painelcaixaAviso.add(img);
                break;
        }
        
        return corAviso;
    }
    //

    public void setIcon(JFrame icone) {
        icone.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/unip/sicc/natureMessage/image/logo.png")));
    }
    
}
