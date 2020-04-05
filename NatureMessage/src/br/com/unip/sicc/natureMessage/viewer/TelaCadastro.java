package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;
import br.com.unip.sicc.natureMessage.exception.PasswordsDontMatch;
import br.com.unip.sicc.natureMessage.exception.UserRegisteredException;
import br.com.unip.sicc.natureMessage.model.Cadastro;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TelaCadastro {

    public JTextField txfNome;
    public JTextField txfSobreNome;
    public JTextField txfDataNasc;
    public JTextField txfEmail;
    public JTextField txfEndereco;
    public JTextField txfEmpresa;
    public JTextField txfCargo;
    public JTextField txfUsuario;
    public JPasswordField pwdSenha;
    public JPasswordField pwdConfirmaSenha;

    ImageIcon imagemVoltar = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/setaVoltar.png"));
    JLabel mostraVoltar = new JLabel(imagemVoltar);
    JFrame telaCadastro = new JFrame();
    PainelPadrao painelCadastro = new PainelPadrao();
    PainelPadrao painelPadrao = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    Cadastro cadastro = new Cadastro();

    public TelaCadastro() {
        telaCadastro.add(montaPainelCadastro());
        telaCadastro.setSize(900, 500);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setUndecorated(true);
        telaCadastro.setVisible(true);
    }

    public JPanel montaPainelCadastro() {

        JButton btnVoltar = new JButton();
        btnVoltar.setBounds(15, 10, 25, 25);
        btnVoltar.setBorder(null);
        btnVoltar.setBackground(null);
        btnVoltar.setForeground(null);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setIcon(imagemVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                    cadastro.AcaoLimpar(txfNome, txfSobreNome, txfCargo, txfEmpresa, txfEndereco, txfDataNasc, txfEmail, txfUsuario, pwdSenha, pwdConfirmaSenha);
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

        txfSobreNome = new JTextField("");
        txfSobreNome.setBorder(null);
        txfSobreNome.setForeground(Color.WHITE);
        txfSobreNome.setBackground(null);
        txfSobreNome.setBounds(30, 120, 300, 25);

        txfDataNasc = new JTextField("");
        txfDataNasc.setBorder(null);
        txfDataNasc.setForeground(Color.WHITE);
        txfDataNasc.setBackground(null);
        txfDataNasc.setBounds(30, 180, 300, 25);

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
        JLabel txtLblNome = new JLabel("Nome:");
        txtLblNome.setForeground(Color.WHITE);
        txtLblNome.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblNome.setBounds(29, 33, 350, 32);

        JLabel txtLblSobreNome = new JLabel("Sobrenome:");
        txtLblSobreNome.setForeground(Color.WHITE);
        txtLblSobreNome.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblSobreNome.setBounds(29, 93, 350, 32);

        JLabel txtLblDataNasc = new JLabel("Data de nascimento:");
        txtLblDataNasc.setForeground(Color.WHITE);
        txtLblDataNasc.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblDataNasc.setBounds(29, 153, 350, 32);

        JLabel txtLblEmail = new JLabel("Email:");
        txtLblEmail.setForeground(Color.WHITE);
        txtLblEmail.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblEmail.setBounds(29, 213, 350, 32);

        JLabel txtLblEndereco = new JLabel("Endereço:");
        txtLblEndereco.setForeground(Color.WHITE);
        txtLblEndereco.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblEndereco.setBounds(29, 273, 350, 32);

        JLabel txtLblEmpresa = new JLabel("Empresa:");
        txtLblEmpresa.setForeground(Color.WHITE);
        txtLblEmpresa.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblEmpresa.setBounds(29, 333, 350, 32);

        JLabel txtLblCargo = new JLabel("Cargo:");
        txtLblCargo.setForeground(Color.WHITE);
        txtLblCargo.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblCargo.setBounds(570, 33, 350, 32);

        JLabel txtLblUsuario = new JLabel("Nome de usuario:");
        txtLblUsuario.setForeground(Color.WHITE);
        txtLblUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblUsuario.setBounds(570, 93, 350, 32);

        JLabel txtLblSenha = new JLabel("Senha:");
        txtLblSenha.setForeground(Color.WHITE);
        txtLblSenha.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblSenha.setBounds(570, 153, 350, 32);

        JLabel txtLblConfirmaSenha = new JLabel("Confirme sua senha:");
        txtLblConfirmaSenha.setForeground(Color.WHITE);
        txtLblConfirmaSenha.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblConfirmaSenha.setBounds(570, 213, 350, 32);

        /* Separadores */
        JSeparator linhaSeparatorNome = new JSeparator();
        linhaSeparatorNome.setForeground(Color.WHITE);
        linhaSeparatorNome.setBounds(30, 85, 300, 1);

        JSeparator linhaSeparatorSobreNome = new JSeparator();
        linhaSeparatorSobreNome.setForeground(Color.WHITE);
        linhaSeparatorSobreNome.setBounds(30, 145, 300, 1);

        JSeparator linhaSeparatorDataNasc = new JSeparator();
        linhaSeparatorDataNasc.setForeground(Color.WHITE);
        linhaSeparatorDataNasc.setBounds(30, 205, 300, 1);

        JSeparator linhaSeparatorEmail = new JSeparator();
        linhaSeparatorEmail.setForeground(Color.WHITE);
        linhaSeparatorEmail.setBounds(30, 265, 300, 1);

        JSeparator linhaSeparatorEndereco = new JSeparator();
        linhaSeparatorEndereco.setForeground(Color.WHITE);
        linhaSeparatorEndereco.setBounds(30, 325, 300, 1);

        JSeparator linhaSeparatorEmpresa = new JSeparator();
        linhaSeparatorEmpresa.setForeground(Color.WHITE);
        linhaSeparatorEmpresa.setBounds(30, 385, 300, 1);

        JSeparator linhaSeparatorCargo = new JSeparator();
        linhaSeparatorCargo.setForeground(Color.WHITE);
        linhaSeparatorCargo.setBounds(570, 85, 300, 1);

        JSeparator linhaSeparatorUsuario = new JSeparator();
        linhaSeparatorUsuario.setForeground(Color.WHITE);
        linhaSeparatorUsuario.setBounds(570, 145, 300, 1);

        JSeparator linhaSeparatorSenha = new JSeparator();
        linhaSeparatorSenha.setForeground(Color.WHITE);
        linhaSeparatorSenha.setBounds(570, 205, 300, 1);

        JSeparator linhaSeparatorConfirmaSenha = new JSeparator();
        linhaSeparatorConfirmaSenha.setForeground(Color.WHITE);
        linhaSeparatorConfirmaSenha.setBounds(570, 265, 300, 1);

        /* Botao */
        JButton btnCadastra = new JButton();
        btnCadastra = botoesPadrao.montaBtnAlteravel();
        btnCadastra.setText("Cadastrar");
        btnCadastra.setBounds(570, 280, 300, 30);
        btnCadastra.setBackground(new Color(0, 255, 127));
        btnCadastra.setForeground(Color.WHITE);
        btnCadastra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                linhaSeparatorNome.setForeground(botoesPadrao.validaCorCampo(txfNome.getText()));
                linhaSeparatorSobreNome.setForeground(botoesPadrao.validaCorCampo(txfSobreNome.getText()));
                linhaSeparatorDataNasc.setForeground(botoesPadrao.validaCorCampo(txfDataNasc.getText()));
                linhaSeparatorCargo.setForeground(botoesPadrao.validaCorCampo(txfCargo.getText()));
                linhaSeparatorEmpresa.setForeground(botoesPadrao.validaCorCampo(txfEmpresa.getText()));
                linhaSeparatorEndereco.setForeground(botoesPadrao.validaCorCampo(txfEndereco.getText()));
                linhaSeparatorEmail.setForeground(botoesPadrao.validaCorCampo(txfEmail.getText()));
                linhaSeparatorSenha.setForeground(botoesPadrao.validaCorCampo(pwdSenha.getText()));
                linhaSeparatorUsuario.setForeground(botoesPadrao.validaCorCampo(txfUsuario.getText()));
                linhaSeparatorConfirmaSenha.setForeground(botoesPadrao.validaCorCampo(pwdSenha.getText()));

                try {
                        cadastro.CadastroUsuario(txfNome.getText(), txfSobreNome.getText(), txfCargo.getText(),
                                txfEmpresa.getText(), txfEndereco.getText(), txfDataNasc.getText(), txfEmail.getText(), txfUsuario.getText(), pwdSenha.getText(), pwdConfirmaSenha.getText());
                } catch (InsufficientCharactersException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (UserRegisteredException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (PasswordsDontMatch ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                telaCadastro.dispose();
                new TelaLogin();
                }
        });

        JButton btnLimpar = new JButton();
        btnLimpar = botoesPadrao.montaBtnAlteravel();
        btnLimpar.setText("Limpar");
        btnLimpar.setBounds(570, 320, 300, 30);
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Todos os campo serão limpos,Deseja continuar?") == 0) {
                    cadastro.AcaoLimpar(txfNome, txfSobreNome, txfCargo, txfEmpresa, txfEndereco, txfDataNasc, txfEmail, txfUsuario, pwdSenha, pwdConfirmaSenha);
                }
            }
        });

        painelCadastro.add(btnVoltar);
        //painelPadrao.add(txtLblTitulo);
        painelCadastro.add(txfNome);
        painelCadastro.add(txfSobreNome);
        painelCadastro.add(txfDataNasc);
        painelCadastro.add(txfEmail);
        painelCadastro.add(txfEndereco);
        painelCadastro.add(txfEmpresa);
        painelCadastro.add(txfCargo);
        painelCadastro.add(txfUsuario);
        painelCadastro.add(pwdSenha);
        painelCadastro.add(pwdConfirmaSenha);
        painelCadastro.add(txtLblNome);
        painelCadastro.add(txtLblSobreNome);
        painelCadastro.add(txtLblDataNasc);
        painelCadastro.add(txtLblEmail);
        painelCadastro.add(txtLblEndereco);
        painelCadastro.add(txtLblEmpresa);
        painelCadastro.add(txtLblCargo);
        painelCadastro.add(txtLblUsuario);
        painelCadastro.add(txtLblSenha);
        painelCadastro.add(txtLblConfirmaSenha);
        painelCadastro.add(linhaSeparatorNome);
        painelCadastro.add(linhaSeparatorSobreNome);
        painelCadastro.add(linhaSeparatorDataNasc);
        painelCadastro.add(linhaSeparatorEmail);
        painelCadastro.add(linhaSeparatorEndereco);
        painelCadastro.add(linhaSeparatorEmpresa);
        painelCadastro.add(linhaSeparatorCargo);
        painelCadastro.add(linhaSeparatorUsuario);
        painelCadastro.add(linhaSeparatorSenha);
        painelCadastro.add(linhaSeparatorConfirmaSenha);
        painelCadastro.add(btnCadastra);
        painelCadastro.add(btnLimpar);

        return painelCadastro;
    }
}
