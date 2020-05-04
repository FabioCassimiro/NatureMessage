package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaConexao {

    PainelPadrao pnlConexao = new PainelPadrao();
    JFrame telaConexao = new JFrame();
    public static String usuarioBD;
    public static String senhaBD;
    JTextField txfUsuario;
    JPasswordField pwdSenha;

    public TelaConexao() {
        telaConexao.add(montaPainelConexaoBancoDeDados());
        telaConexao.setSize(900, 500);
        telaConexao.setLocationRelativeTo(null);
        telaConexao.setUndecorated(true);
        telaConexao.setVisible(true);
    }

    public JPanel montaPainelConexaoBancoDeDados() {

        pnlConexao.add(Componentes.montaTexto("CONEXÃO", 35, Color.WHITE, 360, 100, 350, 37));
        pnlConexao.add(Componentes.montaTexto("BANCO DE DADOS", 15, Color.WHITE, 380, 128, 350, 25));
        pnlConexao.add(Componentes.montaTexto("Usuario:", 12, Color.WHITE, 277, 258, 350, 25));
        pnlConexao.add(Componentes.montaTexto("Senha", 12, Color.WHITE, 277, 306, 350, 25));
        pnlConexao.add(Componentes.montaSeparadora(277, 305, 350, 1));
        pnlConexao.add(Componentes.montaSeparadora(277, 355, 350, 1));
        txfUsuario = Componentes.montaTxfPadrao(277, 275, 350, 30);
        pwdSenha = Componentes.montaPwdPadrao(277, 325, 350, 30);

        JButton btnEntraBanco = Componentes.montaBotaoAlteravel("Entrar");
        btnEntraBanco.setBounds(277, 375, 350, 30);
        btnEntraBanco.setBackground(new Color(0, 255, 127));
        btnEntraBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioBD = txfUsuario.getText();
                senhaBD = pwdSenha.getText();
                telaConexao.dispose();
                new TelaLogin();
            }
        });
        pnlConexao.add(btnEntraBanco);
        pnlConexao.add(txfUsuario);
        pnlConexao.add(pwdSenha);

        return pnlConexao;
    }
}
