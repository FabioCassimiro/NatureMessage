package br.com.unip.sicc.natureMessage.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    public static Connection conexao() {
        try {
            Connection conect = null;
            final String url = "jdbc:mysql://25.104.205.56:3306/teste?useTimeZone=true&serverTimezone=UTC";
            final String noLoginBanco = "admin";
            final String noSenhaBanco = "naturemessage@_@125311314";
            return conect = DriverManager.getConnection(url, noLoginBanco, noSenhaBanco);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
