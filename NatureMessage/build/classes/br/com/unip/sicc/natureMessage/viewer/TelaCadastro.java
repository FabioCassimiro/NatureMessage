package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigCadastro;
import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;
import br.com.unip.sicc.natureMessage.exception.PasswordsDontMatchException;
import br.com.unip.sicc.natureMessage.exception.UserRegisteredException;
import br.com.unip.sicc.natureMessage.model.Cadastro;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaCadastro {

    private JTextField txfNome;
    private JTextField txfSobrenome;
    private JFormattedTextField txfDtNasc;
    private JTextField txfEmail;
    private JTextField txfEndereco;
    private JTextField txfEmpresa;
    private JTextField txfCargo;
    private JTextField txfUsuario;
    private JPasswordField pwdSenha;
    private JPasswordField pwdConfirmaSenha;
    private JLabel lblNome;
    private JLabel lblSobreNome;
    private JLabel lblDataNasc;
    private JLabel lblEmail;
    private JLabel lblEndereco;
    private JLabel lblEmpresa;
    private JLabel lblCargo;
    private JLabel lblUsuario;
    private JLabel lblSenha;
    private JLabel lblConfirmaSenha;
    private JSeparator lnsNome;
    private JSeparator lnsSobrenome;
    private JSeparator lnsDtNasc;
    private JSeparator lnsEmail;
    private JSeparator lnsEndereco;
    private JSeparator lnsEmpresa;
    private JSeparator lnsCargo;
    private JSeparator lnsUsuario;
    private JSeparator lnsSenha;
    private JSeparator lnsConfirmaSenha;
    private JButton btnCadastra;
    private JButton btnLimpar;
    private JButton btnVoltar;
    private ImageIcon imagemVoltar = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/setaVoltar.png"));
    private JLabel mostraVoltar = new JLabel(imagemVoltar);
    private JFrame telaCadastro = new JFrame();
    private PainelPadrao pnlCadastro = new PainelPadrao();
    private PainelPadrao pnlPadrao = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private Cadastro cadastro = new Cadastro();
    ConfigCadastro configCad = new ConfigCadastro();
    MaskFormatter mascara;

    public TelaCadastro() {
        telaCadastro.add(montaPainelCadastro());
        telaCadastro.setSize(900, 500);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setUndecorated(true);
        telaCadastro.setVisible(true);
    }

    public JPanel montaPainelCadastro() {

        btnVoltar = new JButton();
        btnVoltar.setBounds(15, 10, 25, 25);
        btnVoltar.setBorder(null);
        btnVoltar.setBackground(null);
        btnVoltar.setForeground(null);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setIcon(imagemVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!txfNome.getText().equals("") || !txfSobrenome.getText().equals("") || !txfCargo.getText().equals("")
                        || !txfEmpresa.getText().equals("") || !txfEndereco.getText().equals("") || !txfEmail.getText().equals("")
                        || !txfUsuario.getText().equals("") || !pwdSenha.getText().equals("") || !pwdConfirmaSenha.getText().equals("")) {
                    if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                        cadastro.AcaoLimpar(txfNome, txfSobrenome, txfCargo, txfEmpresa, txfEndereco, txfDtNasc,
                                txfEmail, txfUsuario, pwdSenha, pwdConfirmaSenha);

                        telaCadastro.dispose();
                        new TelaLogin();

                    }

                } else {
                    telaCadastro.dispose();
                    new TelaLogin();

                }
            }
        });

        /* TextField */
        txfNome = new JTextField("");
        txfNome.setBorder(null);
        txfNome.setForeground(Color.WHITE);
        txfNome.setBackground(null);
        txfNome.setBounds(30, 60, 300, 25);

        txfSobrenome = new JTextField("");
        txfSobrenome.setBorder(null);
        txfSobrenome.setForeground(Color.WHITE);
        txfSobrenome.setBackground(null);
        txfSobrenome.setBounds(30, 120, 300, 25);
        
        try {
            txfDtNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
            } catch (ParseException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        txfDtNasc.setBorder(null);
        txfDtNasc.setForeground(Color.WHITE);
        txfDtNasc.setBackground(null);
        txfDtNasc.setBounds(30, 180, 300, 25);

        txfEmail = new JTextField("");
        txfEmail.setBorder(null);
        txfEmail.setForeground(Color.WHITE);
        txfEmail.setBackground(null);
        txfEmail.setBounds(30, 240, 300, 25);

        txfEndereco = new JTextField("");
        txfEndereco.setBorder(null);
        txfEndereco.setForeground(Color.WHITE);
        txfEndereco.setBackground(null);
        txfEndereco.setBounds(30, 300, 300, 25);

        txfEmpresa = new JTextField("");
        txfEmpresa.setBorder(null);
        txfEmpresa.setForeground(Color.WHITE);
        txfEmpresa.setBackground(null);
        txfEmpresa.setBounds(30, 360, 300, 25);

        txfCargo = new JTextField("");
        txfCargo.setBorder(null);
        txfCargo.setForeground(Color.WHITE);
        txfCargo.setBackground(null);
        txfCargo.setBounds(570, 60, 300, 25);

        txfUsuario = new JTextField("");
        txfUsuario.setBorder(null);
        txfUsuario.setForeground(Color.WHITE);
        txfUsuario.setBackground(null);
        txfUsuario.setBounds(570, 120, 300, 25);

        pwdSenha = new JPasswordField("");
        pwdSenha.setBorder(null);
        pwdSenha.setForeground(Color.WHITE);
        pwdSenha.setBackground(null);
        pwdSenha.setBounds(570, 180, 300, 25);

        pwdConfirmaSenha = new JPasswordField("");
        pwdConfirmaSenha.setBorder(null);
        pwdConfirmaSenha.setForeground(Color.WHITE);
        pwdConfirmaSenha.setBackground(null);
        pwdConfirmaSenha.setBounds(570, 240, 300, 25);

        /* Labels */
        lblNome = new JLabel("Nome:");
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Arial", Font.BOLD, 12));
        lblNome.setBounds(29, 33, 350, 32);

        lblSobreNome = new JLabel("Sobrenome:");
        lblSobreNome.setForeground(Color.WHITE);
        lblSobreNome.setFont(new Font("Arial", Font.BOLD, 12));
        lblSobreNome.setBounds(29, 93, 350, 32);

        lblDataNasc = new JLabel("Data de nascimento:");
        lblDataNasc.setForeground(Color.WHITE);
        lblDataNasc.setFont(new Font("Arial", Font.BOLD, 12));
        lblDataNasc.setBounds(29, 153, 350, 32);

        lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
        lblEmail.setBounds(29, 213, 350, 32);

        lblEndereco = new JLabel("Endereço:");
        lblEndereco.setForeground(Color.WHITE);
        lblEndereco.setFont(new Font("Arial", Font.BOLD, 12));
        lblEndereco.setBounds(29, 273, 350, 32);

        lblEmpresa = new JLabel("Empresa:");
        lblEmpresa.setForeground(Color.WHITE);
        lblEmpresa.setFont(new Font("Arial", Font.BOLD, 12));
        lblEmpresa.setBounds(29, 333, 350, 32);

        lblCargo = new JLabel("Cargo:");
        lblCargo.setForeground(Color.WHITE);
        lblCargo.setFont(new Font("Arial", Font.BOLD, 12));
        lblCargo.setBounds(570, 33, 350, 32);

        lblUsuario = new JLabel("Nome de usuario:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsuario.setBounds(570, 93, 350, 32);

        lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(new Font("Arial", Font.BOLD, 12));
        lblSenha.setBounds(570, 153, 350, 32);

        lblConfirmaSenha = new JLabel("Confirme sua senha:");
        lblConfirmaSenha.setForeground(Color.WHITE);
        lblConfirmaSenha.setFont(new Font("Arial", Font.BOLD, 12));
        lblConfirmaSenha.setBounds(570, 213, 350, 32);

        /* Separadores */
        lnsNome = new JSeparator();
        lnsNome.setForeground(Color.WHITE);
        lnsNome.setBounds(30, 85, 300, 1);

        lnsSobrenome = new JSeparator();
        lnsSobrenome.setForeground(Color.WHITE);
        lnsSobrenome.setBounds(30, 145, 300, 1);

        lnsDtNasc = new JSeparator();
        lnsDtNasc.setForeground(Color.WHITE);
        lnsDtNasc.setBounds(30, 205, 300, 1);

        lnsEmail = new JSeparator();
        lnsEmail.setForeground(Color.WHITE);
        lnsEmail.setBounds(30, 265, 300, 1);

        lnsEndereco = new JSeparator();
        lnsEndereco.setForeground(Color.WHITE);
        lnsEndereco.setBounds(30, 325, 300, 1);

        lnsEmpresa = new JSeparator();
        lnsEmpresa.setForeground(Color.WHITE);
        lnsEmpresa.setBounds(30, 385, 300, 1);

        lnsCargo = new JSeparator();
        lnsCargo.setForeground(Color.WHITE);
        lnsCargo.setBounds(570, 85, 300, 1);

        lnsUsuario = new JSeparator();
        lnsUsuario.setForeground(Color.WHITE);
        lnsUsuario.setBounds(570, 145, 300, 1);

        lnsSenha = new JSeparator();
        lnsSenha.setForeground(Color.WHITE);
        lnsSenha.setBounds(570, 205, 300, 1);

        lnsConfirmaSenha = new JSeparator();
        lnsConfirmaSenha.setForeground(Color.WHITE);
        lnsConfirmaSenha.setBounds(570, 265, 300, 1);

        /* Botao */
        btnCadastra = new JButton();
        btnCadastra = componentes.montaBtnAlteravel();
        btnCadastra.setText("Cadastrar");
        btnCadastra.setBounds(570, 280, 300, 30);
        btnCadastra.setBackground(new Color(0, 255, 127));
        btnCadastra.setForeground(Color.WHITE);
        btnCadastra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lnsNome.setForeground(componentes.validaCorCampo(txfNome.getText()));
                lnsSobrenome.setForeground(componentes.validaCorCampo(txfSobrenome.getText()));
                lnsDtNasc.setForeground(componentes.validaCorCampo(txfDtNasc.getText()));
                lnsCargo.setForeground(componentes.validaCorCampo(txfCargo.getText()));
                lnsEmpresa.setForeground(componentes.validaCorCampo(txfEmpresa.getText()));
                lnsEndereco.setForeground(componentes.validaCorCampo(txfEndereco.getText()));
                lnsEmail.setForeground(componentes.validaCorCampo(txfEmail.getText()));
                lnsSenha.setForeground(componentes.validaCorCampoSenha(pwdSenha.getText()));
                lnsUsuario.setForeground(componentes.validaCorCampoUsuario(txfUsuario.getText()));
                lnsConfirmaSenha.setForeground(componentes.validaCorCampoSenha(pwdSenha.getText()));

                try {
                    //Validações do cadastro.
                    configCad.ConfigCadastroValida(txfUsuario.getText(), pwdSenha.getText());
                    cadastro.CadastroUsuario(txfNome.getText(), txfSobrenome.getText(), txfCargo.getText(),
                            txfEmpresa.getText(), txfEndereco.getText(), txfDtNasc.getText(), txfEmail.getText(),
                            txfUsuario.getText(), pwdSenha.getText(), pwdConfirmaSenha.getText());
                    telaCadastro.dispose();
                    new TelaLogin();
                } catch (InsufficientCharactersException | UserRegisteredException | PasswordsDontMatchException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnLimpar = new JButton();
        btnLimpar = componentes.montaBtnAlteravel();
        btnLimpar.setText("Limpar");
        btnLimpar.setBounds(570, 320, 300, 30);
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                    cadastro.AcaoLimpar(txfNome, txfSobrenome, txfCargo, txfEmpresa, txfEndereco, txfDtNasc,
                            txfEmail, txfUsuario, pwdSenha, pwdConfirmaSenha);
                }
            }
        });

        pnlCadastro.add(btnVoltar);
        pnlCadastro.add(txfNome);
        pnlCadastro.add(txfSobrenome);
        pnlCadastro.add(txfDtNasc);
        pnlCadastro.add(txfEmail);
        pnlCadastro.add(txfEndereco);
        pnlCadastro.add(txfEmpresa);
        pnlCadastro.add(txfCargo);
        pnlCadastro.add(txfUsuario);
        pnlCadastro.add(pwdSenha);
        pnlCadastro.add(pwdConfirmaSenha);
        pnlCadastro.add(lblNome);
        pnlCadastro.add(lblSobreNome);
        pnlCadastro.add(lblDataNasc);
        pnlCadastro.add(lblEmail);
        pnlCadastro.add(lblEndereco);
        pnlCadastro.add(lblEmpresa);
        pnlCadastro.add(lblCargo);
        pnlCadastro.add(lblUsuario);
        pnlCadastro.add(lblSenha);
        pnlCadastro.add(lblConfirmaSenha);
        pnlCadastro.add(lnsNome);
        pnlCadastro.add(lnsSobrenome);
        pnlCadastro.add(lnsDtNasc);
        pnlCadastro.add(lnsEmail);
        pnlCadastro.add(lnsEndereco);
        pnlCadastro.add(lnsEmpresa);
        pnlCadastro.add(lnsCargo);
        pnlCadastro.add(lnsUsuario);
        pnlCadastro.add(lnsSenha);
        pnlCadastro.add(lnsConfirmaSenha);
        pnlCadastro.add(btnCadastra);
        pnlCadastro.add(btnLimpar);

        return pnlCadastro;
    }
}
