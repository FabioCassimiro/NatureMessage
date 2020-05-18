package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.exception.InvalidPasswordException;
import br.com.unip.sicc.natureMessage.exception.UserInvalidException;
import br.com.unip.sicc.natureMessage.viewer.Componentes;
import javax.swing.JOptionPane;

public class ConfigLogin {

    private AcoesBancoDeDados AcoesBD = new AcoesBancoDeDados();
    private Componentes componentes = new Componentes();

    //Faz a validação do login e da senha digitada pelo usuário e retorna um aviso!
    public String ValidaUsuarioSenha(String usuario, String senha) throws UserInvalidException, InvalidPasswordException {
        String[] camposUsuario = {"NOLOGIN", "NOSENHA"};
        String[] camposDados = {usuario, senha};
        AcoesBD.consultaCredenciais(AcoesBancoDeDados.comandoSelect(camposUsuario, camposDados, "TB_USUARIO"));

        if (usuario.equals(AcoesBancoDeDados.resultNoLogin) && senha.equals(AcoesBancoDeDados.resultNoSenha)) {
            String[] camposPessoa = {"CDPESSOA"};
            String[] dadosPessoa = {AcoesBancoDeDados.resultCdUsuario};

            AcoesBancoDeDados.atualizaUltimoLogin(AcoesBancoDeDados.comandoUpdate("VISTO", "Entrada no sistema: " + Componentes.dataHoraAtual(), " NOLOGIN = " + "'" + AcoesBancoDeDados.resultNoLogin + "'", "TB_USUARIO"));
            AcoesBancoDeDados.consultaPessoa(AcoesBancoDeDados.comandoSelect(camposPessoa, dadosPessoa, "TB_PESSOA"));
            return AcoesBancoDeDados.resultNoLogin;
        }
        if (usuario.equals(AcoesBancoDeDados.resultNoLogin) && !senha.equals(AcoesBancoDeDados.resultNoSenha)) {
            JOptionPane.showMessageDialog(null, "Senha ou usuário informado invalido!", "Login", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (!usuario.equals(AcoesBancoDeDados.resultNoLogin)) {
            JOptionPane.showMessageDialog(null, "Senha ou usuário informado invalido!", "Login", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return null;
    }
    //Fim validação

}
