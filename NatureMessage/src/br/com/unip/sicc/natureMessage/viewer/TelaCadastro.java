package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigCadastro;
import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;
import br.com.unip.sicc.natureMessage.exception.PasswordsDontMatchException;
import br.com.unip.sicc.natureMessage.exception.UserRegisteredException;
import br.com.unip.sicc.natureMessage.model.Cadastro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private JFrame telaCadastro = new JFrame();
    private PainelPadrao pnlCadastro = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private Cadastro cadastro = new Cadastro();
    ConfigCadastro configCad = new ConfigCadastro();

    public TelaCadastro() {
        telaCadastro.add(montaPainelCadastro());
        telaCadastro.setSize(900, 500);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setUndecorated(true);
        telaCadastro.setVisible(true);
    }

    public JPanel montaPainelCadastro() {

        btnVoltar = Componentes.btnIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/setaVoltar.png"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txfNome.getText().equals("") || !txfSobrenome.getText().equals("") || !txfCargo.getText().equals("")
                        || !txfEmpresa.getText().equals("") || !txfEndereco.getText().equals("") || !txfEmail.getText().equals("")
                        || !txfUsuario.getText().equals("") || !pwdSenha.getText().equals("") || !pwdConfirmaSenha.getText().equals("")) {
                    if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                        Cadastro.AcaoLimpar(txfNome, txfSobrenome, txfCargo, txfEmpresa, txfEndereco, txfDtNasc,
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
        txfNome = Componentes.montaTxfPadrao(60, "ESQUERDA");
        txfSobrenome = Componentes.montaTxfPadrao(120, "ESQUERDA");

        try {
            txfDtNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        txfDtNasc.setBorder(null);
        txfDtNasc.setForeground(Color.WHITE);
        txfDtNasc.setBackground(null);
        txfDtNasc.setBounds(30, 180, 300, 25);

        txfEmail = Componentes.montaTxfPadrao(240, "ESQUERDA");
        txfEndereco = Componentes.montaTxfPadrao(300, "ESQUERDA");
        txfEmpresa = Componentes.montaTxfPadrao(360, "ESQUERDA");
        txfCargo = Componentes.montaTxfPadrao(60, "DIREITA");
        txfUsuario = Componentes.montaTxfPadrao(120, "DIREITA");

        pwdSenha = new JPasswordField();
        pwdSenha.setBorder(null);
        pwdSenha.setForeground(Color.WHITE);
        pwdSenha.setBackground(null);
        pwdSenha.setBounds(570, 180, 300, 25);

        pwdConfirmaSenha = new JPasswordField();
        pwdConfirmaSenha.setBorder(null);
        pwdConfirmaSenha.setForeground(Color.WHITE);
        pwdConfirmaSenha.setBackground(null);
        pwdConfirmaSenha.setBounds(570, 240, 300, 25);

        /* Labels */
        JLabel lblNome = Componentes.montaLabelPadrao("Nome:", "ESQUERDA", 33);
        JLabel lblSobreNome = Componentes.montaLabelPadrao("Sobrenome:", "ESQUERDA", 93);
        JLabel lblDataNasc = Componentes.montaLabelPadrao("Data de Nascimento:", "ESQUERDA", 153);
        JLabel lblEmail = Componentes.montaLabelPadrao("Email:", "ESQUERDA", 213);
        JLabel lblEndereco = Componentes.montaLabelPadrao("Endereco:", "ESQUERDA", 273);
        JLabel lblEmpresa = Componentes.montaLabelPadrao("Empresa:", "ESQUERDA", 333);
        JLabel lblCargo = Componentes.montaLabelPadrao("Cargo:", "DIREITA", 33);
        JLabel lblUsuario = Componentes.montaLabelPadrao("Usuario:", "DIREITA", 93);
        JLabel lblSenha = Componentes.montaLabelPadrao("Senha:", "DIREITA", 153);
        JLabel lblConfirmaSenha = Componentes.montaLabelPadrao("Confirme a senha:", "DIREITA", 213);

        /* Separadores */
        lnsNome = Componentes.linhaSeparadora(85, "ESQUERDA");
        lnsSobrenome = Componentes.linhaSeparadora(145, "ESQUERDA");
        lnsDtNasc = Componentes.linhaSeparadora(205, "ESQUERDA");
        lnsEmail = Componentes.linhaSeparadora(265, "ESQUERDA");
        lnsEndereco = Componentes.linhaSeparadora(325, "ESQUERDA");
        lnsEmpresa = Componentes.linhaSeparadora(385, "ESQUERDA");
        lnsCargo = Componentes.linhaSeparadora(85, "DIREITA");
        lnsUsuario = Componentes.linhaSeparadora(145, "DIREITA");
        lnsSenha = Componentes.linhaSeparadora(205, "DIREITA");
        lnsConfirmaSenha = Componentes.linhaSeparadora(265, "DIREITA");


        /* Botao */
        btnCadastra = componentes.montaBtnAlteravel("Cadastrar");
        btnCadastra.setBounds(570, 280, 300, 30);
        btnCadastra.setBackground(new Color(0, 255, 127));
        btnCadastra.setForeground(Color.WHITE);
        btnCadastra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validacaoCampos();
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

        btnLimpar = componentes.montaBtnAlteravel("Limpar");
        btnLimpar.setBounds(570, 320, 300, 30);
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                    Cadastro.AcaoLimpar(txfNome, txfSobrenome, txfCargo, txfEmpresa, txfEndereco, txfDtNasc,
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

    public void validacaoCampos() {
        lnsNome.setForeground(Componentes.validaCampo(txfNome.getText(), "VALIDAR"));
        lnsSobrenome.setForeground(Componentes.validaCampo(txfSobrenome.getText(), "VALIDAR"));
        lnsDtNasc.setForeground(Componentes.validaCampo(txfDtNasc.getText(), "VALIDAR"));
        lnsCargo.setForeground(Componentes.validaCampo(txfCargo.getText(), "VALIDAR"));
        lnsEmpresa.setForeground(Componentes.validaCampo(txfEmpresa.getText(), "VALIDAR"));
        lnsEndereco.setForeground(Componentes.validaCampo(txfEndereco.getText(), "VALIDAR"));
        lnsEmail.setForeground(Componentes.validaCampo(txfEmail.getText(), "VALIDAR"));
        lnsSenha.setForeground(Componentes.validaCampoSenha(pwdSenha.getText(), pwdConfirmaSenha.getText(), "VALIDA"));
        lnsUsuario.setForeground(Componentes.validaCampo(txfUsuario.getText(), "VALIDAR"));
        lnsConfirmaSenha.setForeground(Componentes.validaCampoSenha(pwdSenha.getText(), pwdConfirmaSenha.getText(), "VALIDA"));
    }
}
