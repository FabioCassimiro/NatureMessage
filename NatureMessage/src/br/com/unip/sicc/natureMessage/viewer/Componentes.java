package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Componentes {

    JFrame caixaAvisoMsg = new JFrame();
    JPanel painelCaixaAviso = new JPanel();
    JButton btnOkay;

    public ImageIcon buscaImagem(String nomeArquivo) {
        ImageIcon imagem = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/" + nomeArquivo));
        return imagem;
    }

    public static JLabel montaTexto(String conteudo, int tamanhoFonte, Color corfonte, int x, int y, int altura, int largura) {
        JLabel texto = new JLabel(conteudo);
        texto.setForeground(corfonte);
        texto.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        texto.setBounds(x, y, altura, largura);
        return texto;
    }

    public static JSeparator montaSeparadora(int x, int y, int altura, int largura) {
        JSeparator linha = new JSeparator();
        linha.setForeground(Color.WHITE);
        linha.setBounds(x, y, altura, largura);
        return linha;
    }

    public static JButton montaBotaoIcone(ImageIcon icone, int x, int y, int altura, int largura, ActionListener acao) {
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

    public static JButton montaBotaoPadrao(String nome) {

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

    public static JButton montaBotaoAlteravel(String nome) {
        JButton btnPadrao = new JButton(nome);
        btnPadrao.setBorder(null);
        btnPadrao.setFocusPainted(false);
        btnPadrao.setFont(new Font("Arial", Font.BOLD, 15));
        btnPadrao.setForeground(Color.WHITE);
        return btnPadrao;
    }

    public static Color validaCampoSenha(String campoSenha, String campoConfirmaSenha, String acao) {
        Color cor = null;

        if (acao.equals("VALIDA")) {
            cor = campoSenha.equals(campoConfirmaSenha) && campoSenha.length() != 0 ? Color.GREEN : Color.RED;
        }
        if (acao.equals("RESETAR")) {
            cor = Color.white;
        }

        return cor;
    }

    public static Color validaCampoEspecial(String campo, String acao) {
        Color cor = null;

        if (acao.equals("VALIDAR")) {
            cor = campo.length() <= 7 ? Color.red : Color.GREEN;
        }
        if (acao.equals("RESETAR")) {

            cor = Color.white;
        }
        return cor;
    }

    public static Color validaCampo(String campo, String acao) {
        Color cor = null;

        if (acao.equals("VALIDAR")) {
            cor = campo.equals("") ? Color.red : Color.GREEN;
        }
        if (acao.equals("RESETAR")) {
            cor = Color.white;
        }
        return cor;
    }

    public JButton redesSociais(String urlSite, String image, String link, String aluno, int x, int y, int width, int heigth) {

        String redeSocial = urlSite.equals("INSTAGRAM") ? "Instagram" : urlSite.equals("GITHUB") ? "GitHub" : "LinkedIn";

        JButton linkRedesSociais = montaBotaoPadrao(redeSocial);
        linkRedesSociais.setBounds(x, y, width, heigth);
        linkRedesSociais.setFont(new Font("Arial", Font.BOLD, 11));
        linkRedesSociais.setIcon(buscaImagem(image));
        linkRedesSociais.setToolTipText(aluno);
        linkRedesSociais.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    if (urlSite.equals("INSTAGRAM")) {
                        Runtime.getRuntime().exec("cmd.exe /C start " + "https://instagram.com/" + link);
                    }
                    if (urlSite.equals("GITHUB")) {
                        Runtime.getRuntime().exec("cmd.exe /C start " + "https://github.com/" + link);
                    }
                    if (urlSite.equals("LINKEDIN")) {
                        Runtime.getRuntime().exec("cmd.exe /C start " + "https://www.linkedin.com/" + link);
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        return linkRedesSociais;
    }

    public static JRadioButton montaRadio(String conteudo, int x, int y) {
        JRadioButton radio = new JRadioButton(conteudo);
        radio.setBackground(null);
        radio.setForeground(Color.WHITE);
        radio.setBorder(null);
        radio.setFocusPainted(false);
        radio.setFont(new Font("Arial", Font.BOLD, 12));
        radio.setBounds(x, y, 39, 20);
        return radio;
    }

    public static String dataHoraAtual() {
        Date data = new Date();
        Calendar dataAtual = new GregorianCalendar();
        data.setTime(data.getTime());
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM ");
        SimpleDateFormat formata = new SimpleDateFormat("h:mm a");
        return formata.format(data) + " | " + formatador.format(data);
    }

    public void montaIconeFrame(JFrame icone) {
        icone.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/unip/sicc/natureMessage/image/logo.png")));
    }

    public static JLabel btnMinimizar(JFrame janela) {
        JLabel minimizar = new JLabel("_");
        minimizar.setForeground(Color.WHITE);
        minimizar.setFont(new Font("Arial", Font.BOLD, 25));
        minimizar.setBounds(845, -1, 25, 25);
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                janela.setExtendedState(JFrame.ICONIFIED);
            }
        });

        return minimizar;
    }
}
