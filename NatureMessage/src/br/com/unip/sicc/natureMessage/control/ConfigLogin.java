package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
import br.com.unip.sicc.natureMessage.viewer.BotoesPadrao;
import javax.swing.JOptionPane;

public class ConfigLogin {

    
    AcoesBancoDeDados banco = new AcoesBancoDeDados();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
/*
    public ConfigLogin(String noLogin, String noSenha) {
        //Lançamento de excetion.
        try {
            ValidaUsuarioSenha(noLogin, noSenha);
        } catch (UserInvalidException usuarioInvalido) {
            JOptionPane.showMessageDialog(null, usuarioInvalido.getMessage());
        } catch (InvalidPasswordException senhaInvalida) {
            JOptionPane.showMessageDialog(null, senhaInvalida.getMessage());
        }
        //Fim lançamento.
    }
*/
    //Faz a validação do login e da senha digitada pelo usuário e retorna um aviso!
    public String ValidaUsuarioSenha(String usuario, String senha) throws UserInvalidException, InvalidPasswordException {
        banco.ConsultaLoginSenha("SELECT * FROM TB_USUARIO WHERE NOLOGIN = '" + usuario + "'");
        banco.ConsultaLoginSenha("SELECT * FROM TB_USUARIO WHERE NOLOGIN = '" + usuario + "' AND NOSENHA = '" + senha + "'");

        if (usuario.equals(banco.getNome()) && senha.equals(banco.getSenha())) {
            
            return "Logado";
        }
        if (usuario.equals(banco.getNome()) && !senha.equals(banco.getSenha())) {
            botoesPadrao.montaAvisoMensagem("Senha ou usuário informado invalido!", "ERRO");
            return "Não Logado";
        }
        if (!usuario.equals(banco.getNome())) {
           botoesPadrao.montaAvisoMensagem("Senha ou usuário informado invalido!", "ERRO");
           return "Não Logado";
        }
        return null;
    }
    //Fim validação

}
