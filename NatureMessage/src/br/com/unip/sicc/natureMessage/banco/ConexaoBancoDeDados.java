package br.com.unip.sicc.natureMessage.banco;

import br.com.unip.sicc.natureMessage.viewer.TelaConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    public static Connection conexao() {
        try {
            Connection conect = null;
            final String url = "jdbc:mysql://localhost:3306/teste?useTimeZone=true&serverTimezone=UTC";
            //final String noLoginBanco = TelaConexao.usuarioBD;
            //final String noSenhaBanco = TelaConexao.senhaBD;
            final String noLoginBanco = "root";
            final String noSenhaBanco = "";
            return conect = DriverManager.getConnection(url, noLoginBanco, noSenhaBanco);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
