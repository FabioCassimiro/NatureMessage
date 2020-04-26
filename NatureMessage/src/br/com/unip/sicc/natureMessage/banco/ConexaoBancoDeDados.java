package br.com.unip.sicc.natureMessage.banco;

import br.com.unip.sicc.natureMessage.viewer.Componentes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBancoDeDados {

    private final String url = "jdbc:mysql://localhost:3306/teste?useTimeZone=true&serverTimezone=UTC";
    private final String drive = "com.mysql.jdbc.Driver";
    private final String noLoginBanco = "root" ;
    private final String noSenhaBanco  = "";
    private Connection conect = null;
    Componentes botao =  new Componentes();

    

   

    public Connection conexao() {
        try {
            Class.forName(drive);
           return conect = DriverManager.getConnection(url, noLoginBanco, noSenhaBanco);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Não foi possivel estabeler conexão");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
