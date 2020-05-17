package br.com.unip.sicc.natureMessage.banco;

import br.com.unip.sicc.natureMessage.viewer.TelaLogin;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AcoesBancoDeDados {

    public static String resultNoLogin;
    public static String resultNoSenha;
    public static String resultCdUsuario;
    public static String resulIpServidor;
    public static String resulPtServidor;
    public static String resultCdServidor;
    public static String resultNoServidor;
    public static String mensagemCompleta = "";
    public static String noPessoa;
    public static String noSobrenome;
    public static String noCargo;
    public static String noEmpresa;

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
        String comando = "";

        switch (tabela) {
            case "TB_USUARIO":
                comando = "INSERT INTO TB_USUARIO (NOLOGIN,NOSENHA) VALUES(";
                break;
            case "TB_PESSOA":
                comando = "INSERT INTO TB_PESSOA(NOPESSOA,NOSOBRENOME,DTNASCIMENTO,NOEMAIL,NOENDERECO,NOEMPRESA,NOCARGO) VALUES(";
                break;
            case "TB_RELATORIO":
                comando = "INSERT INTO TB_RELATORIO (NORELATORIO,NOLOGIN,NOEMPRESA,DTCRIACAO,SITUACAO,OBSERVACAO) VALUES (";
                break;
        }

        for (int i = 0; i < campos.length; i++) {

            if (i == campos.length - 1) {
                comando += "'" + campos[i] + "')";
            } else {
                comando += "'" + campos[i] + "'" + ",";
            }

        }
        System.out.println(comando);
        return comando;
    }

    //UPDATE tb_usuario SET VISTO = "08/05 as 00:46" WHERE NOLOGIN = "fcassimiro";
    public static String comandoUpdate(String campo, String valor, String condicao, String tabela) {
        String comando = "UPDATE " + tabela + " SET " + campo + " = " + "'" + valor + "'" + " WHERE " + condicao;
        return comando;
    }

//->Consulta usuário no banco de dados.
    public static void ConsultaLoginSenha(String sqlquery) {
        try {
            System.out.println(sqlquery);
            PreparedStatement pesquisa = ConexaoBancoDeDados.conexao().prepareStatement(sqlquery);
            ResultSet resultado = pesquisa.executeQuery();
            while (resultado.next()) {
                if (!resultado.equals("")) {
                    resultNoLogin = resultado.getString("noLogin");
                    resultNoSenha = resultado.getString("noSenha");
                    resultCdUsuario = resultado.getString("CdUsuario");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " Erro consulta de Usuario.\n Exception Banco de dados");
        }
    }
    //->Fim Consulta usuário.

    //->Cria usuario no banco de dados
    public static void CriaCadastroUsuario(String sqlquery) {

        try {
            Statement cadatastro = ConexaoBancoDeDados.conexao().createStatement();
            cadatastro.executeUpdate(sqlquery);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Erro criação de Usuario/Pessoa .\n Exception Banco de dados");
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
            JOptionPane.showMessageDialog(null, " Erro consulta de Servidor.\n Exception Banco de dados");
        }
    }

    public static void atualizaUltimoLogin(String sqlquery) {

        try {
            Statement cadatastro = ConexaoBancoDeDados.conexao().createStatement();
            cadatastro.executeUpdate(sqlquery);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " Erro atualizar visto por ultimo.\n Exception Banco de dados");
        }
    }

    public static void ConsultaPessoa(String sqlQuery) {
        try {
            PreparedStatement servidor = ConexaoBancoDeDados.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();
            while (resultado.next()) {
                if (!resultado.equals("")) {
                    noPessoa = resultado.getString("noPessoa");
                    noSobrenome = resultado.getString("noSobrenome");
                    noCargo = resultado.getString("noCargo");
                    noEmpresa = resultado.getString("noEmpresa");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Erro consulta de Servidor.\n Exception Banco de dados");
        }
    }

    public static void carregaMensagem(String sqlQuery) {
        try {
            System.out.println(sqlQuery);
            PreparedStatement servidor = ConexaoBancoDeDados.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();

            while (resultado.next()) {
                if (!resultado.equals("")) {
                    String resultNoMensagem = resultado.getString("NOMENSAGEM");
                    String resultNoUsuario = resultado.getString("NOUSUARIO");
                    String resultHrEnvio = resultado.getString("DTENVIO");
                    if (mensagemCompleta.equals("")) {
                        mensagemCompleta = resultNoUsuario + "  " + resultNoMensagem + "  " + resultHrEnvio;
                    } else {
                        mensagemCompleta += "\n\n" + resultNoUsuario + "  " + resultNoMensagem + "  " + resultHrEnvio;

                    }
                }
            }
            System.out.println(mensagemCompleta);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Erro ao carregar mensagens.\n Exception Banco de dados");
        }
    }

}
