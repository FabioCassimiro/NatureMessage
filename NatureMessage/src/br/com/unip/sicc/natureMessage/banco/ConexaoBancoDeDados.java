package br.com.unip.sicc.natureMessage.banco;

import br.com.unip.sicc.natureMessage.viewer.BotoesPadrao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBancoDeDados {

    String url = "jdbc:mysql://localhost:3306/naturemessage?useTimeZone=true&serverTimezone=UTC";
    private String noLoginBanco = "root" ;
    private String noSenhaBanco  = "";
    private Connection conect = null;
    BotoesPadrao botao =  new BotoesPadrao();

    

   

    public Connection conexao() {
        try {
            conect = DriverManager.getConnection(url, noLoginBanco, noSenhaBanco);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Não foi possivel estabeler conexão");
            botao.montaAvisoMensagem("Erro", "ERRO");
        }
        return conect;

    }

}
