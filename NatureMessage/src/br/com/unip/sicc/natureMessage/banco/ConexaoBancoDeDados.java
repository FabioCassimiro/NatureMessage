package br.com.unip.sicc.natureMessage.banco;

import br.com.unip.sicc.natureMessage.viewer.TelaInicial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBancoDeDados {

    public static final String url = TelaInicial.noEnderecoBanco.equals("")
            ? "jdbc:mysql://25.104.205.56:3306/naturemessage?useTimeZone=true&serverTimezone=UTC"
            : "jdbc:mysql://" + TelaInicial.noEnderecoBanco + ":3306/" + TelaInicial.noBanco + "?useTimeZone=true&serverTimezone=UTC";
    public static final String noUsuarioBanco = TelaInicial.noUsuarioBanco.equals("") ? "admin" : TelaInicial.noUsuarioBanco;
    public static final String noSenhaBanco = !TelaInicial.noSenhaBanco.equals("nulo") ? "naturemessage@_@125311314" : "";
    public static final String noBanco = TelaInicial.noBanco.equals("") ? "teste" : TelaInicial.noBanco;

    public static Connection conexao() {
        try {
            Connection conect = null;
            return conect = DriverManager.getConnection(url, noUsuarioBanco, noSenhaBanco);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Erro de conexão com o Banco de Dados .\n Exception Banco de dados",
                    "NatureMessage", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }

}
