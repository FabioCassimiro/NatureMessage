package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.control.ConfigLogin;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
import java.awt.Color;
import java.awt.JobAttributes;
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
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TelaLogin {

    private ConfigLogin login = new ConfigLogin();
    private PainelPadrao pnlLogin = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private JFrame telaLogin = new JFrame();
    private JTextField txfUsuario;
    private JPasswordField pwdSenha;
    public static String nomeUsuario;

    public TelaLogin() {
        telaLogin.add(montaPainelLogin());
        telaLogin.setSize(900, 500);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setUndecorated(true);
        telaLogin.setVisible(true);
        componentes.montaIconeFrame(telaLogin);
    }

    public JPanel montaPainelLogin() {
        
        JButton btnVoltar = Componentes.montaBtnIcone(componentes.buscaImagem("setaVoltar.png"), 15, 10, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.dispose();
                new TelaInicial();
            }
        });
        
        pnlLogin.add(Componentes.montaBtnMinimizar(telaLogin));
        pnlLogin.add(Componentes.montaTexto("LOGIN", 35, Color.WHITE, 405, 100, 350, 32));
        pnlLogin.add(Componentes.montaTexto("TALK NOW!", 15, Color.white, 418, 127, 350, 25));
        pnlLogin.add(Componentes.montaTexto("Usuario:", 12, Color.WHITE, 277, 202, 350, 25));
        pnlLogin.add(Componentes.montaTexto("Senha:", 12, Color.WHITE, 277, 260, 350, 25));
        pnlLogin.add(Componentes.montaSeparadora(277, 255, 350, 1));
        pnlLogin.add(Componentes.montaSeparadora(277, 318, 350, 1));
        
        JLabel lblImageSenha = new JLabel(componentes.buscaImagem("cadeado.png"));
        lblImageSenha.setBounds(277, 285, 30, 30);
        
        JLabel lblImageLogin = new JLabel(componentes.buscaImagem("usuario.png"));
        lblImageLogin.setBounds(277, 225, 30, 30);
        
        txfUsuario = Componentes.montaTxfPadrao(306, 225, 320, 30);
        pwdSenha = Componentes.montaPwdPadrao(306, 285, 320, 30);

        JButton btnEntra = Componentes.montaBotaoAlteravel("Entrar");
        btnEntra.setBounds(277, 342, 350, 30);
        btnEntra.setBackground(new Color(0, 255, 127));

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

                    nomeUsuario = login.ValidaUsuarioSenha(txfUsuario.getText(), pwdSenha.getText());
                    if (nomeUsuario != null) {
                        telaLogin.dispose();
                        new TelaServidor();
                        JOptionPane.showMessageDialog(null, "Bem-Vindo ao NatureMessage \n","Nature Message",JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (UserInvalidException | InvalidPasswordException ex) {
                    
                }
            }

        });

        JButton btnCadastro = Componentes.montaBtnPadrao("Cadastre-se!");
        btnCadastro.setBounds(404, 377, 100, 25);
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.dispose();
                new TelaCadastro();
            }
        });

        pnlLogin.add(lblImageSenha);
        pnlLogin.add(lblImageLogin);
        pnlLogin.add(txfUsuario);
        pnlLogin.add(pwdSenha);
        pnlLogin.add(btnEntra);
        pnlLogin.add(btnCadastro);
        pnlLogin.add(btnVoltar);

        return pnlLogin;
    }
}
