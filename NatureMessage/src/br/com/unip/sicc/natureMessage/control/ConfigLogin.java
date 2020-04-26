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
        AcoesBD.ConsultaLoginSenha("SELECT * FROM TB_USUARIO WHERE NOLOGIN = '" + usuario + "' AND NOSENHA = '" + senha + "'");

        if (usuario.equals(AcoesBD.getNome()) && senha.equals(AcoesBD.getSenha())) {
            return AcoesBD.getNomeUsuario();
        }
        if (usuario.equals(AcoesBD.getNome()) && !senha.equals(AcoesBD.getSenha())) {
            componentes.montaAvisoMensagem("Senha ou usuário informado invalido!", "ERRO");
            return null;
        }
        if (!usuario.equals(AcoesBD.getNome())) {
           componentes.montaAvisoMensagem("Senha ou usuário informado invalido!", "ERRO");
           return null;
        }
        return null;
    }
    //Fim validação

}
