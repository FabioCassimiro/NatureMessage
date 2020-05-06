package br.com.unip.sicc.natureMessage.banco;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AcoesBancoDeDados {

    private String nome;
    private String senha;
    private String resulIpServidor;
    private String resulPortaServidor;
    private String resultNoHostname;
    private String nomeServidor;
    private String nomeUsuario;
    ConexaoBancoDeDados conexao = new ConexaoBancoDeDados();
    public static String mensagem;
    public static String mensagemCompleta;

    public String getResulIpServidor() {
        return resulIpServidor;
    }

    public String getNomeServidor() {
        return nomeServidor;
    }

    public String getResulPortaServidor() {
        return resulPortaServidor;
    }

    public String getResultNoHostname() {
        return resultNoHostname;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public static String comandoSelect(String[] campos, String[] dados, String tabela) {
        String comando = dados.length == 0 && campos.length == 0 ? "SELECT * FROM " +tabela  : "SELECT * FROM " + tabela + " WHERE ";

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
                comando += "'" + campos[i] + "'";
            } else {
                comando += "'" + campos[i] + "'" + ",";
            }
        }
        for (int i = 0; i < campos.length; i++) {
            if (i == campos.length - 1) {
                comando += "'" + campos[i] + "'" + ")";
            } else {
                comando += "'" + campos[i] + "'" + ",";
            }
        }

        System.out.println(comando);
        return comando;
    }

//->Consulta usuário no banco de dados.
    public void ConsultaLoginSenha(String sqlquery) {
        try {

            PreparedStatement pesquisa = conexao.conexao().prepareStatement(sqlquery);
            ResultSet resultado = pesquisa.executeQuery();

            while (resultado.next()) {
                nome = resultado.getString("noLogin");
                senha = resultado.getString("noSenha");
                nomeUsuario = resultado.getString("noLogin");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro");
            e.printStackTrace();
        }
    }
    //->Fim Consulta usuário.

    //->Cria usuario no banco de dados
    public void CriaCadastroUsuario(String sqlquery) {

        try {
            Statement cadatastro = conexao.conexao().createStatement();
            cadatastro.executeUpdate(sqlquery);
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro de Banco de dados");
            e.printStackTrace();
        }
    }
    //->Fim criação usuario.

    public void ConsultaServidor(String sqlQuery) {
        try {
            PreparedStatement servidor = conexao.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();

            while (resultado.next()) {
                if (!resultado.equals("")) {
                    resulIpServidor = resultado.getString("IPSERVIDOR");
                    resulPortaServidor = resultado.getString("PTSERVIDOR");
                    resultNoHostname = resultado.getString("CDSERVIDOR");
                    nomeServidor = resultado.getString("NOSERVIDOR");

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void carregaMensagem(String sqlQuery) {
        try {
            PreparedStatement servidor = ConexaoBancoDeDados.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();

            while (resultado.next()) {
                if (!resultado.equals("")) {
                    mensagem = resultado.getString("NOMENSAGEM");
                    String usuario = resultado.getString("NOUSUARIO");
                    String data = resultado.getString("DTENVIO");
                    mensagemCompleta += "\n" + usuario + "  " + mensagem + "  " + data;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
