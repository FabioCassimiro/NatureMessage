package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
import br.com.unip.sicc.natureMessage.viewer.Componentes;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ConfigLogin {

    
    private AcoesBancoDeDados AcoesBD = new AcoesBancoDeDados();
    private Componentes componentes = new Componentes();
    
    //Faz a validação do login e da senha digitada pelo usuário e retorna um aviso!
    public String ValidaUsuarioSenha(String usuario, String senha) throws UserInvalidException, InvalidPasswordException {
        String[] camposUsuario = {"NOLOGIN","NOSENHA"};
        String[] camposDados = {usuario,senha};
        AcoesBD.ConsultaLoginSenha(AcoesBancoDeDados.comandoSelect(camposUsuario, camposDados, "TB_USUARIO"));
        
        if (usuario.equals(AcoesBancoDeDados.resultNoLogin) && senha.equals(AcoesBancoDeDados.resultNoSenha)) {
            Calendar dataHora = Calendar.getInstance();
            String data = dataHora.get(Calendar.HOUR_OF_DAY) + ":" + dataHora.get(Calendar.MINUTE)
             + "  " + dataHora.get(Calendar.DAY_OF_WEEK) +  "/" + dataHora.get(Calendar.DAY_OF_MONTH) ;
            AcoesBancoDeDados.atualizaUltimoLogin(AcoesBancoDeDados.comandoUpdate("VISTO","Entrada no sistema: " + data," NOLOGIN = " + "'" + AcoesBancoDeDados.resultNoLogin + "'" ,"TB_USUARIO"));
            return AcoesBancoDeDados.resultNoLogin;
        }
        if (usuario.equals(AcoesBancoDeDados.resultNoLogin) && !senha.equals(AcoesBancoDeDados.resultNoSenha)) {
            JOptionPane.showMessageDialog(null, "Senha ou usuário informado invalido!","Login",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (!usuario.equals(AcoesBancoDeDados.resultNoLogin)) {
           JOptionPane.showMessageDialog(null, "Senha ou usuário informado invalido!","Login",JOptionPane.ERROR_MESSAGE);
           return null;
        }
        return null;
    }
    //Fim validação

}
