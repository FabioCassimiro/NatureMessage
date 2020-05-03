package br.com.unip.sicc.natureMessage.model;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.control.ConfigCadastro;
import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;
import br.com.unip.sicc.natureMessage.exception.PasswordsDontMatchException;
import br.com.unip.sicc.natureMessage.exception.UserRegisteredException;
import javax.swing.JTextField;

public class Cadastro {

    private String criaPessoa;
    private String criaUsuario;
    AcoesBancoDeDados banco = new AcoesBancoDeDados();

    public void CadastroUsuario(String noPessoa, String noSobrenome, String noCargo, String noEmpresa, String noEndereco,
            String dtNascimento, String noEmail, String noLogin, String noSenha, String confirmacaoSenha) throws InsufficientCharactersException, UserRegisteredException, PasswordsDontMatchException {

        banco.ConsultaLoginSenha("SELECT * FROM TB_USUARIO WHERE NOLOGIN = '" + noLogin + "'");
        if (!noPessoa.equals("") && !noSobrenome.equals("") && !noCargo.equals("") && !noEmpresa.equals("") && !noEndereco.equals("")
                && !dtNascimento.equals("  /  /    ") && !noEmail.equals("") && !noLogin.equals("") && !noSenha.equals("")) {

            if (!noLogin.equals(banco.getNome())) {
                if (noSenha.equals(confirmacaoSenha)) {
                    criaPessoa = "INSERT INTO TB_PESSOA(NOPESSOA,NOSOBRENOME,DTNASCIMENTO,NOEMAIL,NOENDERECO,NOEMPRESA,NOCARGO) VALUES(" + "'" + noPessoa + "'" + "," + "'"
                            + noSobrenome + "'" + "," + "'" + noCargo + "'" + "," + "'" + noEmpresa + "'" + "," + "'" + noEndereco + "'"
                            + "," + "'" + dtNascimento + "'" + "," + "'" + noEmail + "'" + ")";

                    criaUsuario = "INSERT INTO TB_USUARIO (NOLOGIN,NOSENHA) VALUES(" + "'" + noLogin + "'" + "," + "'" + noSenha + "'" + ")";
                    banco.CriaCadastroUsuario(criaUsuario);
                    banco.CriaCadastroUsuario(criaPessoa);

                } else {
                    throw new PasswordsDontMatchException("Senhas não conferemem");
                }

            } else {
                throw new UserRegisteredException("Usuario já registrado");
            }

        } else {
            throw new InsufficientCharactersException("Campo obrigatorios não precenchidos");

        }

    }

    public static void AcaoLimpar(JTextField txfNome, JTextField txfSobreNome, JTextField txfCargo, JTextField txfEmpresa, JTextField txfEndereco, JTextField txfDataNasc,
            JTextField txfEmail, JTextField txfUsuario, JTextField pwdSenha, JTextField pwdConfirmaSenha) {
        txfNome.setText("");
        txfSobreNome.setText("");
        txfCargo.setText("");
        txfEmpresa.setText("");
        txfEndereco.setText("");
        txfDataNasc.setText("");
        txfEmail.setText("");
        txfUsuario.setText("");
        pwdSenha.setText("");
        pwdConfirmaSenha.setText("");

    }

}
