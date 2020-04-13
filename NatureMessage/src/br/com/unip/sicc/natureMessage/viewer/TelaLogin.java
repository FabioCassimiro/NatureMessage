package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigLogin;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TelaLogin {

    private ConfigLogin login = new ConfigLogin();
    private JButton btnEntra;
    private PainelPadrao pnlLogin = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private JFrame telaLogin = new JFrame();
    private JLabel lblTitulo;
    private JTextField txfUsuario;
    private JPasswordField pwdSenha;
    private JLabel lblUsuario;
    private JLabel lblSenha;
    private JSeparator lnsUsuario;
    private JSeparator lnsSenha;
    private JButton btnCadastro;
    private JLabel lblTalkNow;

    public TelaLogin() {
        telaLogin.add(montaPainelLogin());
        telaLogin.setSize(900, 500);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setUndecorated(true);
        telaLogin.setVisible(true);
    }

    public JPanel montaPainelLogin() {
        lblTitulo = new JLabel("LOGIN");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        lblTitulo.setBounds(405, 100, 350, 32);

        txfUsuario = new JTextField();
        txfUsuario.setBorder(null);
        txfUsuario.setForeground(Color.WHITE);
        txfUsuario.setBackground(null);
        txfUsuario.setBounds(277, 225, 350, 30);

        pwdSenha = new JPasswordField();
        pwdSenha.setBorder(null);
        pwdSenha.setForeground(Color.WHITE);
        pwdSenha.setBackground(null);
        pwdSenha.setBounds(277, 285, 350, 30);
      
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsuario.setBounds(277, 202, 350, 25);

        lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(new Font("Arial", Font.BOLD, 12));
        lblSenha.setBounds(277, 260, 350, 25);

        lnsUsuario = new JSeparator();
        lnsUsuario.setForeground(Color.WHITE);
        lnsUsuario.setBounds(277, 255, 350, 1);

        lnsSenha = new JSeparator();
        lnsSenha.setForeground(Color.WHITE);
        lnsSenha.setBounds(277, 318, 350, 1);

        btnEntra = new JButton();
        btnEntra = componentes.montaBtnAlteravel();
        btnEntra.setText("Entrar");
        btnEntra.setBounds(277, 342, 350, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        btnEntra.setForeground(Color.WHITE);
        
        Action actionTecla = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnEntra.doClick();
            }
        };
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        InputMap inputMap = btnEntra.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "Tecla_Enter");
        ActionMap actionMap = btnEntra.getActionMap();
        actionMap.put("Tecla_Enter", actionTecla);
        btnEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String result = login.ValidaUsuarioSenha(txfUsuario.getText(), pwdSenha.getText());
                    if (result != null) {
                        telaLogin.dispose();
                        TelaServidor telaServidor = new TelaServidor();
                        telaServidor.setNomeUsuario(result);
                        componentes.montaAvisoMensagem("Bem-Vindo  " + result, "SUCESSO");
                    }

                } catch (UserInvalidException usuarioInvalido) {
                    JOptionPane.showMessageDialog(null, usuarioInvalido.getMessage());
                } catch (InvalidPasswordException senhaInvalida) {
                    JOptionPane.showMessageDialog(null, senhaInvalida.getMessage());
                }
            }

        });

        btnCadastro = new JButton();
        btnCadastro = componentes.montaBtnPadrao();
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

        lblTalkNow = new JLabel("TALK NOW!");
        lblTalkNow.setForeground(Color.WHITE);
        lblTalkNow.setFont(new Font("Arial", Font.BOLD, 15));
        lblTalkNow.setBounds(418, 127, 350, 25);

        pnlLogin.add(lblTitulo);
        pnlLogin.add(txfUsuario);
        pnlLogin.add(pwdSenha);
        pnlLogin.add(lblUsuario);
        pnlLogin.add(lblSenha);
        pnlLogin.add(lnsUsuario);
        pnlLogin.add(lnsSenha);
        pnlLogin.add(btnEntra);
        pnlLogin.add(lblTalkNow);
        pnlLogin.add(btnCadastro);

        return pnlLogin;
    }
}
