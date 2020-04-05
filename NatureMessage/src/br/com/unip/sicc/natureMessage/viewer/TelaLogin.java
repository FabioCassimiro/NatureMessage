package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.control.ConfigLogin;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TelaLogin {

    ConfigLogin login = new ConfigLogin();

    PainelPadrao painelLogin = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    JFrame telaLogin = new JFrame();

    public TelaLogin() {
        telaLogin.add(montaPainelLogin());
        telaLogin.setSize(900, 500);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setUndecorated(true);
        telaLogin.setVisible(true);
    }

    public JPanel montaPainelLogin() {
        JLabel txtLblTitulo = new JLabel("LOGIN");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        txtLblTitulo.setBounds(405, 100, 350, 32);

        JTextField txfUsuario = new JTextField();
        txfUsuario.setBorder(null);
        txfUsuario.setForeground(Color.WHITE);
        txfUsuario.setBackground(null);
        txfUsuario.setBounds(277, 225, 350, 30);

        JPasswordField pwdSenha = new JPasswordField();
        pwdSenha.setBorder(null);
        pwdSenha.setForeground(Color.WHITE);
        pwdSenha.setBackground(null);
        pwdSenha.setBounds(277, 285, 350, 30);
        pwdSenha.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                int tecla = KeyEvent.VK_ENTER;
                
                if (codigo == tecla) {
                    try {

                        String result = login.ValidaUsuarioSenha(txfUsuario.getText(), pwdSenha.getText());
                        if (result != null) {
                            telaLogin.dispose();
                            TelaServidor telaServidor =  new TelaServidor();
                            telaServidor.setNomeUsuario(result);
                            botoesPadrao.montaAvisoMensagem("Bem-Vindo  " + result, "SUCESSO");
                        }

                    } catch (UserInvalidException usuarioInvalido) {
                        JOptionPane.showMessageDialog(null, usuarioInvalido.getMessage());
                    } catch (InvalidPasswordException senhaInvalida) {
                        JOptionPane.showMessageDialog(null, senhaInvalida.getMessage());
                    }
                }
            }
        });

        JLabel txtLblSubUsuario = new JLabel("Usuario:");
        txtLblSubUsuario.setForeground(Color.WHITE);
        txtLblSubUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblSubUsuario.setBounds(277, 202, 350, 25);

        JLabel txtLblSubSenha = new JLabel("Senha:");
        txtLblSubSenha.setForeground(Color.WHITE);
        txtLblSubSenha.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblSubSenha.setBounds(277, 260, 350, 25);

        JSeparator linhaSeparatorUsuario = new JSeparator();
        linhaSeparatorUsuario.setForeground(Color.WHITE);
        linhaSeparatorUsuario.setBounds(277, 255, 350, 1);

        JSeparator linhaSeparatorSenha = new JSeparator();
        linhaSeparatorSenha.setForeground(Color.WHITE);
        linhaSeparatorSenha.setBounds(277, 318, 350, 1);

        JButton btnEntra = new JButton();
        btnEntra = botoesPadrao.montaBtnAlteravel();
        btnEntra.setText("Entrar");
        btnEntra.setBounds(277, 342, 350, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        btnEntra.setForeground(Color.WHITE);
        /*btnEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String result = login.ValidaUsuarioSenha(txfUsuario.getText(), pwdSenha.getText());
                    if (result.equals("Logado")) {
                        telaLogin.dispose();
                        new TelaServidor();
                        botoesPadrao.montaAvisoMensagem("Login efetuado!", "SUCESSO");
                    }

                } catch (UserInvalidException usuarioInvalido) {
                    JOptionPane.showMessageDialog(null, usuarioInvalido.getMessage());
                } catch (InvalidPasswordException senhaInvalida) {
                    JOptionPane.showMessageDialog(null, senhaInvalida.getMessage());
                }

            }
        });*/

 /*JLabel txtLblCadastro = new JLabel("Cadastra-se!");
        txtLblCadastro.setForeground(Color.WHITE);
        txtLblCadastro.setFont(new Font("Arial",Font.BOLD, 12));
        txtLblCadastro.setBounds(416, 377, 100, 25);
         */
        JButton btnCadastro = new JButton();
        btnCadastro = botoesPadrao.montaBtnPadrao();
        btnCadastro.setText("Cadastre-se!");
        btnCadastro.setForeground(Color.WHITE);
        btnCadastro.setFont(new Font("Arial", Font.BOLD, 12));
        btnCadastro.setBounds(404, 377, 100, 25);
        btnCadastro.setContentAreaFilled(false);
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.dispose();
                new TelaCadastro();
            }
        });

        JLabel txtLblTalkNow = new JLabel("TALK NOW!");
        txtLblTalkNow.setForeground(Color.WHITE);
        txtLblTalkNow.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblTalkNow.setBounds(418, 127, 350, 25);

        painelLogin.add(txtLblTitulo);
        painelLogin.add(txfUsuario);
        painelLogin.add(pwdSenha);
        painelLogin.add(txtLblSubUsuario);
        painelLogin.add(txtLblSubSenha);
        painelLogin.add(linhaSeparatorUsuario);
        painelLogin.add(linhaSeparatorSenha);
        painelLogin.add(btnEntra);
        //painelPadrao.add(txtLblCadastro);
        painelLogin.add(txtLblTalkNow);
        painelLogin.add(btnCadastro);

        return painelLogin;
    }
}
