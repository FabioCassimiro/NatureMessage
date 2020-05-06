package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
import br.com.unip.sicc.natureMessage.viewer.Componentes;

public class ConfigLogin {

    
    private AcoesBancoDeDados AcoesBD = new AcoesBancoDeDados();
    private Componentes componentes = new Componentes();
    
    //Faz a validação do login e da senha digitada pelo usuário e retorna um aviso!
    public String ValidaUsuarioSenha(String usuario, String senha) throws UserInvalidException, InvalidPasswordException {
        String[] camposUsuario = {"NOLOGIN","NOSENHA"};
        String[] camposDados = {usuario,senha};
        AcoesBD.ConsultaLoginSenha(AcoesBancoDeDados.comandoSelect(camposUsuario, camposDados, "TB_USUARIO"));
        
        if (usuario.equals(AcoesBancoDeDados.resultNoLogin) && senha.equals(AcoesBancoDeDados.resultNoSenha)) {
            return AcoesBancoDeDados.resultNoLogin;
        }
        if (usuario.equals(AcoesBancoDeDados.resultNoLogin) && !senha.equals(AcoesBancoDeDados.resultNoSenha)) {
            componentes.montaMensagemAviso("Senha ou usuário informado invalido!", "ERRO");
            return null;
        }
        if (!usuario.equals(AcoesBancoDeDados.resultNoLogin)) {
           componentes.montaMensagemAviso("Senha ou usuário informado invalido!", "ERRO");
           return null;
        }
        return null;
    }
    //Fim validação

}
