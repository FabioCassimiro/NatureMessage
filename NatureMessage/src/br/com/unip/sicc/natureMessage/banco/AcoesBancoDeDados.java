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
    ConexaoBancoDeDados conexao = new ConexaoBancoDeDados();


    public String getResulIpServidor() {
        return resulIpServidor;
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
    
    
    

    //->Consulta usuário no banco de dados.
    public void ConsultaLoginSenha(String sqlquery) {
        try {

            PreparedStatement pesquisa = conexao.conexao().prepareStatement(sqlquery);
            ResultSet resultado = pesquisa.executeQuery();

            while (resultado.next()) {
                nome = resultado.getString("noLogin");
                senha = resultado.getString("noSenha");

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sss");
            //JOptionPane.showMessageDialog(null, e.getMessage() + " Erro de Banco de dados");
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
        }
    }
    //->Fim criação usuario.

    public void ConsultaServidor(String sqlQuery) {
        try {
            PreparedStatement servidor = conexao.conexao().prepareStatement(sqlQuery);
            ResultSet resultado = servidor.executeQuery();

            while (resultado.next()) {
                
                resulIpServidor = resultado.getString("cdIp");
                resulPortaServidor = resultado.getString("cdPorta");
                resultNoHostname = resultado.getString("noHostname");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
