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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Componentes {

    JFrame caixaAvisoMsg = new JFrame();
    JPanel painelcaixaAviso = new JPanel();
    JButton btnOkay;

    public ImageIcon image(String caminho) {
        ImageIcon imagem = new ImageIcon(getClass().getResource(caminho));
        return imagem;
    }

    public static JLabel lblTexto(String conteudo, int tamanhoFonte, Color corfonte, int x, int y, int altura, int largura) {
        JLabel texto = new JLabel(conteudo);
        texto.setForeground(corfonte);
        texto.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        texto.setBounds(x, y, altura, largura);
        return texto;
    }

    public static JSeparator linhaSeparadora(int x, int y, int altura, int largura) {
        JSeparator linha = new JSeparator();
        linha.setForeground(Color.WHITE);
        linha.setBounds(x, y, altura, largura);

        return linha;
    }

    public static JButton btnIcon(ImageIcon icone, int x, int y, int altura, int largura, ActionListener acao) {
        JButton btnIcon = new JButton();
        btnIcon.setBounds(x, y, altura, largura);
        btnIcon.setBorder(null);
        btnIcon.setBackground(null);
        btnIcon.setForeground(Color.WHITE);
        btnIcon.setContentAreaFilled(false);
        btnIcon.setIcon(icone);
        btnIcon.addActionListener(acao);
        return btnIcon;
    }

    public static JButton montaBtnPadrao(String nome) {

        JButton btnPadrao = new JButton(nome);
        btnPadrao.setBorder(null);
        btnPadrao.setBackground(null);
        btnPadrao.setForeground(null);
        btnPadrao.setContentAreaFilled(false);
        btnPadrao.setFocusPainted(false);
        btnPadrao.setFont(new Font("Arial", Font.BOLD, 12));
        btnPadrao.setForeground(Color.WHITE);
        btnPadrao.setContentAreaFilled(false);
        return btnPadrao;
    }

    public static JTextField montaTxfPadrao(int x, int y, int altura, int largura) {
        JTextField txfPadrao = new JTextField();
        txfPadrao.setBorder(null);
        txfPadrao.setForeground(Color.WHITE);
        txfPadrao.setBackground(null);
        txfPadrao.setBounds(x, y, altura, largura);

        return txfPadrao;
    }

    public static JPasswordField montaPwdPadrao(int x, int y, int altura, int largura) {
        JPasswordField pwdPadrao = new JPasswordField();
        pwdPadrao.setBorder(null);
        pwdPadrao.setForeground(Color.WHITE);
        pwdPadrao.setBackground(null);
        pwdPadrao.setBounds(x, y, altura, largura);
        return pwdPadrao;
    }

    public static JButton montaBtnAlteravel(String nome) {
        JButton btnPadrao = new JButton(nome);
        btnPadrao.setBorder(null);
        btnPadrao.setFocusPainted(false);
        btnPadrao.setFont(new Font("Arial", Font.BOLD, 15));
        btnPadrao.setForeground(Color.WHITE);
        return btnPadrao;
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

        JLabel imgBorda = new JLabel();
        imgBorda.setIcon(image("/br/com/unip/sicc/natureMessage/image/borda.png"));
        imgBorda.setBounds(0, 0, 275, 125);

        btnOkay = montaBtnAlteravel("OK!");//;
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
        JLabel img = new JLabel();
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

    public static Color validaCampoSenha(String campoSenha, String campoConfirmaSenha, String acao) {
        Color cor = null;

        if (acao.equals("VALIDA")) {
            cor = campoSenha.equals(campoConfirmaSenha) ? Color.GREEN : Color.RED;
        }
        if (acao.equals("RESETA")) {
            cor = Color.white;
        }

        return cor;
    }

    public static Color validaCampo(String campo, String acao) {
        Color cor = null;

        if (acao.equals("VALIDAR")) {
            cor = campo.length() <= 7 ? Color.red : Color.GREEN;
        }
        if (acao.equals("RESETAR")) {

            cor = Color.white;
        }
        return cor;
    }

    public void setIcon(JFrame icone) {
        icone.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/unip/sicc/natureMessage/image/logo.png")));
    }
}
