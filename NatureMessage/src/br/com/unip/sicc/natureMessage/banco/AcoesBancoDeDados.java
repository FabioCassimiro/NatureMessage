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

    public static String comandoSelect(String[] campos,String[] dados,  String tabela) {
        String comando = "SELECT * FROM ";
        
        switch(tabela){
            case "TB_USUARIO":
                for (int i = 0; i < campos.length; i++) {
                    comando+= tabela +campos[i] ;
                }
                
            
        }
        return comando;
    }

    public static String comandoInsert(String[] campos, String tabela) {
        String comando = "INSERT INTO ";

        switch (tabela) {
            case "TB_USUARIO":
                comando += tabela + "(NOLOGIN,NOSENHA) VALUES(";
                for (int i = 0; i < campos.length; i++) {
                    if (i == 1) {
                        comando += "'" + campos[i] + "'";
                    } else {
                        comando += "'" + campos[i] + "'" + ",";
                    }
                }
                break;
            case "TB_PESSOA":
                comando += tabela + "(NOPESSOA,NOSOBRENOME,DTNASCIMENTO,NOEMAIL,NOENDERECO,NOEMPRESA,NOCARGO) VALUES(";
                for (int i = 0; i < campos.length; i++) {
                    if (i == 6) {
                        comando += "'" + campos[i] + "'";
                    } else {
                        comando += "'" + campos[i] + "'" + ",";
                    }
                }
                break;
        }

        comando += ")";

        System.out.println(comando);
        return comando;
    }

    //->Consulta usuário no banco de dados.
    public void ConsultaLoginSenha(String sqlquery) {
        try {

            PreparedStatement pesquisa = ConexaoBancoDeDados.conexao().prepareStatement(sqlquery);
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
    public static void CriaCadastroUsuario(String sqlquery) {

        try {
            Statement cadatastro = ConexaoBancoDeDados.conexao().createStatement();
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
            PreparedStatement servidor = ConexaoBancoDeDados.conexao().prepareStatement(sqlQuery);
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

}
