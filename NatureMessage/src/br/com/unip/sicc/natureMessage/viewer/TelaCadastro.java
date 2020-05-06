package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigCadastro;
import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;
import br.com.unip.sicc.natureMessage.exception.PasswordsDontMatchException;
import br.com.unip.sicc.natureMessage.exception.UserRegisteredException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
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
    ConfigCadastro cadastro = new ConfigCadastro();

    public TelaCadastro() {
        telaCadastro.add(montaPainelCadastro());
        telaCadastro.setSize(900, 500);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setUndecorated(true);
        telaCadastro.setVisible(true);
    }

    public JPanel montaPainelCadastro() {

        btnVoltar = Componentes.montaBotaoIcone(componentes.buscaImagem("setaVoltar.png"), 15, 10, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txfNome.getText().equals("") || !txfSobrenome.getText().equals("") || !txfCargo.getText().equals("")
                        || !txfEmpresa.getText().equals("") || !txfEndereco.getText().equals("") || !txfEmail.getText().equals("")
                        || !txfUsuario.getText().equals("") || !pwdSenha.getText().equals("") || !pwdConfirmaSenha.getText().equals("")) {
                    if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                        ConfigCadastro.AcaoLimpar(txfNome, txfSobrenome, txfCargo, txfEmpresa, txfEndereco, txfDtNasc,
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
        txfNome = Componentes.montaTxfPadrao(30, 60, 300, 25);
        txfSobrenome = Componentes.montaTxfPadrao(30, 120, 300, 25);

        try {
            txfDtNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        txfDtNasc.setBorder(null);
        txfDtNasc.setForeground(Color.WHITE);
        txfDtNasc.setBackground(null);
        txfDtNasc.setBounds(30, 180, 300, 25);

        txfEmail = Componentes.montaTxfPadrao(30, 240, 300, 25);
        txfEndereco = Componentes.montaTxfPadrao(30, 300, 300, 25);
        txfEmpresa = Componentes.montaTxfPadrao(30, 360, 300, 25);
        txfCargo = Componentes.montaTxfPadrao(570, 60, 300, 25);
        txfUsuario = Componentes.montaTxfPadrao(570, 120, 300, 25);
        pwdSenha = Componentes.montaPwdPadrao(570, 180, 300, 25);
        pwdConfirmaSenha = Componentes.montaPwdPadrao(570, 240, 300, 25);

        /* Labels */
        pnlCadastro.add(Componentes.montaTexto("Nome:", 12, Color.WHITE, 29, 33, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Sobrenome:", 12, Color.WHITE, 29, 93, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Data de Nascimento:", 12, Color.WHITE, 29, 153, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Email:", 12, Color.WHITE, 29, 213, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Endereco:", 12, Color.WHITE, 29, 273, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Empresa:", 12, Color.WHITE, 29, 333, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Cargo:", 12, Color.WHITE, 570, 33, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Usuario:", 12, Color.WHITE, 570, 93, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Senha:", 12, Color.WHITE, 570, 153, 350, 32));
        pnlCadastro.add(Componentes.montaTexto("Confirme sua senha:", 12, Color.WHITE, 570, 213, 350, 32));


        /* Separadores */
        //lnsNome = Componentes.linhaSeparadora(85, "ESQUERDA");
        lnsNome = Componentes.montaSeparadora(30, 85, 300, 1);
        lnsSobrenome = Componentes.montaSeparadora(30, 145, 300, 1);
        lnsDtNasc = Componentes.montaSeparadora(30, 205, 300, 1);
        lnsEmail = Componentes.montaSeparadora(30, 265, 300, 1);
        lnsEndereco = Componentes.montaSeparadora(30, 325, 300, 1);
        lnsEmpresa = Componentes.montaSeparadora(30, 385, 300, 1);
        lnsCargo = Componentes.montaSeparadora(570, 85, 300, 1);
        lnsUsuario = Componentes.montaSeparadora(570, 145, 300, 1);
        lnsSenha = Componentes.montaSeparadora(570, 205, 300, 1);
        lnsConfirmaSenha = Componentes.montaSeparadora(570, 265, 300, 1);


        /* Botao */
        btnCadastra = componentes.montaBotaoAlteravel("Cadastrar");
        btnCadastra.setBounds(570, 280, 300, 30);
        btnCadastra.setBackground(new Color(0, 255, 127));
        btnCadastra.setForeground(Color.WHITE);
        btnCadastra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validacaoCampos();
                try {
                    //Validações do cadastro.
                    ConfigCadastro.ConfigCadastroValida(txfUsuario.getText(), pwdSenha.getText());
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

        btnLimpar = componentes.montaBotaoAlteravel("Limpar");
        btnLimpar.setBounds(570, 320, 300, 30);
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                    ConfigCadastro.AcaoLimpar(txfNome, txfSobrenome, txfCargo, txfEmpresa, txfEndereco, txfDtNasc,
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
