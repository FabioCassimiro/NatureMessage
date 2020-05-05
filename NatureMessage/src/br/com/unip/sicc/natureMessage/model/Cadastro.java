package br.com.unip.sicc.natureMessage.model;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.control.ConfigCadastro;
import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;
import br.com.unip.sicc.natureMessage.exception.PasswordsDontMatchException;
import br.com.unip.sicc.natureMessage.exception.UserRegisteredException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Cadastro {

    AcoesBancoDeDados banco = new AcoesBancoDeDados();
    String [] camposUsuario = {"NOLOGIN","NOSENHA"};
    
    
    public void CadastroUsuario(String noPessoa, String noSobrenome, String noCargo, String noEmpresa, String noEndereco,
            String dtNascimento, String noEmail, String noLogin, String noSenha, String confirmacaoSenha) throws InsufficientCharactersException, UserRegisteredException, PasswordsDontMatchException {
            String [] dadosUsuario = {noLogin,noSenha};
        banco.ConsultaLoginSenha(AcoesBancoDeDados.comandoSelect(camposUsuario,dadosUsuario,"TB_USUARIO"));
        if (!noPessoa.equals("") && !noSobrenome.equals("") && !noCargo.equals("") && !noEmpresa.equals("") && !noEndereco.equals("")
                && !dtNascimento.equals("  /  /    ") && !noEmail.equals("") && !noLogin.equals("") && !noSenha.equals("")) {

            if (!noLogin.equals(banco.getNome())) {
                if (noSenha.equals(confirmacaoSenha)) {
                    String [] usuario = {noLogin,noSenha}; 
                    String [] pessoa = {noPessoa,noSobrenome,noCargo,noEmpresa,noEndereco,dtNascimento,noEmail};
                    
                    banco.CriaCadastroUsuario(AcoesBancoDeDados.comandoInsert(usuario, "TB_USUARIO"));
                    banco.CriaCadastroUsuario(AcoesBancoDeDados.comandoInsert(pessoa, "TB_PESSOA"));

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
