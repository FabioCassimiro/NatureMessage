package br.com.unip.sicc.natureMessage.banco;

import br.com.unip.sicc.natureMessage.viewer.Componentes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBancoDeDados {
    
    public static Connection conexao() {
        try {
            Connection conect = null;
            final String url = "jdbc:mysql://localhost:3306/teste?useTimeZone=true&serverTimezone=UTC";
            final String drive = "com.mysql.jdbc.Driver";
            final String noLoginBanco = "root";
            final String noSenhaBanco = "";
            Class.forName(drive);
            return conect = DriverManager.getConnection(url, noLoginBanco, noSenhaBanco);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
