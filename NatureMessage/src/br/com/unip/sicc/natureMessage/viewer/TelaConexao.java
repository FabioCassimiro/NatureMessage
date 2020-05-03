package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.banco.ConexaoBancoDeDados;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TelaConexao {

    PainelPadrao painelConexao = new PainelPadrao();
    Componentes botoesPadrao = new Componentes();
    JFrame telaConexao = new JFrame();

    public TelaConexao() {
        telaConexao.add(montaPainelConexaoBancoDeDados());
        telaConexao.setSize(900, 500);
        telaConexao.setLocationRelativeTo(null);
        telaConexao.setUndecorated(true);
        telaConexao.setVisible(true);
    }

    
    public JPanel montaPainelConexaoBancoDeDados() {

        JLabel txtLblTitulo = new JLabel("CONEXÃO");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        txtLblTitulo.setBounds(360, 100, 350, 37);

        JTextField txfUsuario = new JTextField();
        txfUsuario.setBorder(null);
        txfUsuario.setForeground(Color.WHITE);
        txfUsuario.setBackground(null);
        txfUsuario.setBounds(277, 275, 350, 30);

        JPasswordField pwdSenha = new JPasswordField();
        pwdSenha.setBorder(null);
        pwdSenha.setForeground(Color.WHITE);
        pwdSenha.setBackground(null);
        pwdSenha.setBounds(277, 325, 350, 30);

        JLabel txtLblSubUsuario = new JLabel("Usuario:");
        txtLblSubUsuario.setForeground(Color.WHITE);
        txtLblSubUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblSubUsuario.setBounds(277, 258, 350, 25);

        JLabel txtLblSubSenha = new JLabel("Senha:");
        txtLblSubSenha.setForeground(Color.WHITE);
        txtLblSubSenha.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblSubSenha.setBounds(277, 306, 350, 25);

        JSeparator linhaSeparatorUsuario = new JSeparator();
        linhaSeparatorUsuario.setForeground(Color.WHITE);
        linhaSeparatorUsuario.setBounds(277, 305, 350, 1);

        JSeparator linhaSeparatorSenha = new JSeparator();
        linhaSeparatorSenha.setForeground(Color.WHITE);
        linhaSeparatorSenha.setBounds(277, 355, 350, 1);
        
        JButton btnEntraBanco = botoesPadrao.montaBtnAlteravel("Entrar");
        btnEntraBanco.setText("Entrar");
        btnEntraBanco.setBounds(277, 375, 350, 30);
        btnEntraBanco.setBackground(new Color(0, 255, 127));
        btnEntraBanco.setForeground(Color.WHITE);
        btnEntraBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // novaConexao = new ConexaoBancoDeDados(txfUsuario.getText(),pwdSenha.getText());
               telaConexao.dispose();
               new TelaLogin();
            }
        });

        /*JLabel txtLblCadastro = new JLabel("Cadastra-se!");
        txtLblCadastro.setForeground(Color.WHITE);
        txtLblCadastro.setFont(new Font("Arial",Font.BOLD, 12));
        txtLblCadastro.setBounds(416, 377, 100, 25);
         */
        JLabel txtLblBDD = new JLabel("BANCO DE DADOS");
        txtLblBDD.setForeground(Color.WHITE);
        txtLblBDD.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblBDD.setBounds(380, 128, 350, 25);

        painelConexao.add(txtLblTitulo);
        painelConexao.add(txfUsuario);
        painelConexao.add(pwdSenha);
        painelConexao.add(txtLblSubUsuario);
        painelConexao.add(txtLblSubSenha);
        painelConexao.add(linhaSeparatorUsuario);
        painelConexao.add(linhaSeparatorSenha);
        painelConexao.add(btnEntraBanco);
        painelConexao.add(txtLblBDD);

        return painelConexao;
    }
}
