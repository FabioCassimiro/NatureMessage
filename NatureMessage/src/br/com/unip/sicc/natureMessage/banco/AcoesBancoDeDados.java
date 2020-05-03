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
    public void CriaCadastroUsuario(String sqlquery) {

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
