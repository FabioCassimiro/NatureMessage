package br.com.unip.sicc.natureMessage.banco;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AcoesBancoDeDados {

    public static String resultNoLogin;
    public static String resultNoSenha;
    public static String resulIpServidor;
    public static String resulPtServidor;
    public static String resultCdServidor;
    public static String resultNoServidor;
    public static String mensagemCompleta;
    String noPessoa;
    String noSobrenome;


    public static String comandoSelect(String[] campos, String[] dados, String tabela) {
        String comando = dados.length == 0 && campos.length == 0 ? "SELECT * FROM " + tabela : "SELECT * FROM " + tabela + " WHERE ";

        if (campos.length != 0 && dados.length != 0) {

            for (int i = 0; i < campos.length; i++) {
                //Somente uma Condicao
                if (campos.length == 1) {
                    comando += campos[i] + " = " + "'" + dados[i] + "'";
                }
                //Varias condicoes
                if (campos.length > 1) {
                    if (i == campos.length) {
                        comando += campos[i] + " = " + "'" + dados[i] + "'";
                    } else if (i == campos.length - 1) {
                        comando += campos[i] + " = " + "'" + dados[i] + "'";
                    } else {
                        comando += campos[i] + " = " + "'" + dados[i] + "'" + " AND ";
                    }

                }

            }

        }

        return comando;
    }

    public static String comandoInsert(String[] campos, String tabela) {
        String comando = tabela.equals("TB_USUARIO")
                ? "INSERT INTO TB_USUARIO (NOLOGIN,NOSENHA) VALUES("
                : "INSERT INTO TB_PESSOA(NOPESSOA,NOSOBRENOME,DTNASCIMENTO,NOEMAIL,NOENDERECO,NOEMPRESA,NOCARGO) VALUES(";

        for (int i = 0; i < campos.length; i++) {

            if (i == campos.length - 1) {
                comando += "'" + campos[i] + "')";
            } else {
                comando += "'" + campos[i] + "'" + ",";
            }

        }

        return comando;
    }
    
    //UPDATE tb_usuario SET VISTO = "08/05 as 00:46" WHERE NOLOGIN = "fcassimiro";
    public static String comandoUpdate(String campo,String valor,String condicao,String tabela){
     String comando = "UPDATE " +tabela+ " SET " + campo + " = "+ "'" + valor + "'" +" WHERE " + condicao;
        return comando;
    }

//->Consulta usuário no banco de dados.
    public void ConsultaLoginSenha(String sqlquery) {
        try {

            PreparedStatement pesquisa = ConexaoBancoDeDados.conexao().prepareStatement(sqlquery);
            ResultSet resultado = pesquisa.executeQuery();

            while (resultado.next()) {
                resultNoLogin = resultado.getString("noLogin");
                resultNoSenha = resultado.getString("noSenha");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Erro consulta de Usuario.\n Exception Banco de dados");
        }
    }
    //->Fim Consulta usuário.

    //->Cria usuario no banco de dados
    public void CriaCadastroUsuario(String sqlquery) {

        try {
            Statement cadatastro = ConexaoBancoDeDados.conexao().createStatement();
            cadatastro.executeUpdate(sqlquery);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Erro criação de Usuario/Pessoa .\n Exception Banco de dados");
        }
    }
    //->Fim criação usuario.

    public void ConsultaServidor(String sqlQuery) {
        try {
            PreparedStatement servidor = ConexaoBancoDeDados.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();

            while (resultado.next()) {
                if (!resultado.equals("")) {
                    resulIpServidor = resultado.getString("IPSERVIDOR");
                    resulPtServidor = resultado.getString("PTSERVIDOR");
                    resultCdServidor = resultado.getString("CDSERVIDOR");
                    resultNoServidor = resultado.getString("NOSERVIDOR");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Erro consulta de Servidor.\n Exception Banco de dados");
        }
    }
    
    public static void atualizaUltimoLogin(String sqlquery) {

        try {
            Statement cadatastro = ConexaoBancoDeDados.conexao().createStatement();
            cadatastro.executeUpdate(sqlquery);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Erro atualizar visto por ultimo.\n Exception Banco de dados");
        }
    }
    
    public void ConsultaPessoa(String sqlQuery) {
        try {
            PreparedStatement servidor = ConexaoBancoDeDados.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();

            while (resultado.next()) {
                if (!resultado.equals("")) {
                    resulIpServidor = resultado.getString("IPSERVIDOR");
                    resulPtServidor = resultado.getString("PTSERVIDOR");
                    resultCdServidor = resultado.getString("CDSERVIDOR");
                    resultNoServidor = resultado.getString("NOSERVIDOR");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Erro consulta de Servidor.\n Exception Banco de dados");
        }
    }

    public static void carregaMensagem(String sqlQuery) {
        try {
            PreparedStatement servidor = ConexaoBancoDeDados.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();

            while (resultado.next()) {
                if (!resultado.equals("")) {
                    String resultNoMensagem = resultado.getString("NOMENSAGEM");
                    String resultNoUsuario = resultado.getString("NOUSUARIO");
                    String resultHrEnvio = resultado.getString("HRENVIO");
                    mensagemCompleta += "\n" + resultNoUsuario + "  " + resultNoMensagem + "  " + resultHrEnvio;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Erro ao carregar mensagens.\n Exception Banco de dados");
        }
    }

}
