package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigConexaoServidor {
    private String noHostname;
    private int portaServidor;
    private Socket socket;
    private AcoesBancoDeDados dados = new AcoesBancoDeDados();

    public String getNoHostname() {
        return noHostname;
    }

    public int getPortaServidor() {
        return portaServidor;
    }
    
    
    
    
    
    public void ValidaServidor(String cdHostname){
        
        dados.ConsultaServidor("SELECT * FROM TB_SERVIDOR WHERE CDSERVIDOR =" + "'" + cdHostname + "'");
        
        if(!dados.getResulIpServidor().equals("")){
            noHostname = dados.getResultNoHostname();
            portaServidor = Integer.parseInt(dados.getResulPortaServidor());
        }

    }
}
    
   