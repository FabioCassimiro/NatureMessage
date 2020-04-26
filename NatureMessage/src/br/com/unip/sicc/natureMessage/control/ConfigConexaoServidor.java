package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigConexaoServidor {
    private String noHostname;
    Socket socket;
    AcoesBancoDeDados dados = new AcoesBancoDeDados();

    public String getNoHostname() {
        return noHostname;
    }
    
    
    
    public void ValidaServidor(String cdHostname){
        
        dados.ConsultaServidor("SELECT * FROM TB_SERVIDOR WHERE CDSERVIDOR =" + "'" + cdHostname + "'");
        
        if(!dados.getResulIpServidor().equals("")){
            conexaoChat(dados.getResulIpServidor(), Integer.parseInt(dados.getResulPortaServidor()));
            noHostname = dados.getResultNoHostname();
        }

    }
    
    public void entrarServidor(){
        
            
    }
    
    public void conexaoChat(String cdIp, int cdPorta){
        
        try{
            socket = new Socket(cdIp,cdPorta);
            System.out.println("deu");
        } catch (IOException ex) {
           ex.printStackTrace();
        }  
        
        
    }
    
    
        
}
