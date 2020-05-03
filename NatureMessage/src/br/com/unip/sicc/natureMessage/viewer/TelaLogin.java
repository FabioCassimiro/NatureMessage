package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigLogin;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TelaLogin {


    private JButton btnEntra;
    private PainelPadrao pnlLogin = new PainelPadrao();
    
    private JFrame telaLogin = new JFrame();
    private JTextField txfUsuario;
    private JPasswordField pwdSenha;
    private JButton btnCadastro;

    public TelaLogin() {
        telaLogin.add(montaPainelLogin());
        telaLogin.setSize(900, 500);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setUndecorated(true);
        telaLogin.setVisible(true);
    }

    public JPanel montaPainelLogin() {

        pnlLogin.add(Componentes.lblTexto("Usuario", 12, Color.white, 277, 202, 350, 25));
        pnlLogin.add(Componentes.lblTexto("Senha:", 12, Color.white, 277, 260, 350, 25));
        pnlLogin.add(Componentes.lblTexto("TALK NOW!", 15, Color.white, 418, 127, 350, 25));
        pnlLogin.add(Componentes.lblTexto("LOGIN", 35, Color.WHITE, 405, 100, 350, 32));
        txfUsuario = Componentes.montaTxfPadrao(277, 225, 350, 30);
        pwdSenha = Componentes.montaPwdPadrao(277, 225, 350, 30);
        pnlLogin.add(Componentes.linhaSeparadora(277, 255, 350, 1));
        pnlLogin.add(Componentes.linhaSeparadora(277, 318, 350, 1));

        btnEntra = Componentes.montaBtnAlteravel("Entrar");
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

                    String result = ConfigLogin.ValidaUsuarioSenha(txfUsuario.getText(), pwdSenha.getText());
                    if (result != null) {
                        Componentes componentes = new Componentes();
                        telaLogin.dispose();
                        TelaServidor telaServidor = new TelaServidor();
                        telaServidor.setNomeUsuario(result);
                        componentes.montaAvisoMensagem("Bem-Vindo " + result, "SUCESSO");
                    }

                } catch (UserInvalidException usuarioInvalido) {
                    JOptionPane.showMessageDialog(null, usuarioInvalido.getMessage());
                } catch (InvalidPasswordException senhaInvalida) {
                    JOptionPane.showMessageDialog(null, senhaInvalida.getMessage());
                }
            }

        });

        btnCadastro = Componentes.montaBtnPadrao("Cadastre-se!");
        btnCadastro.setBounds(404, 377, 100, 25);
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.dispose();
                new TelaCadastro();
            }
        });

        pnlLogin.add(txfUsuario);
        pnlLogin.add(pwdSenha);
        pnlLogin.add(btnEntra);
        pnlLogin.add(btnCadastro);

        return pnlLogin;
    }
}
