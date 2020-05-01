package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.exception.ServerNotFoundException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigConexaoServidor {

    private String noHostname;
    private int portaServidor;
    private Socket socket;
    private String nomeServidor;
    private AcoesBancoDeDados dados = new AcoesBancoDeDados();

    public String getNoHostname() {
        return noHostname;
    }

    public int getPortaServidor() {
        return portaServidor;
    }

    public String getNomeServidor() {
        return nomeServidor;
    }
    

    public void ValidaServidor(String cdHostname) throws ServerNotFoundException{

        dados.ConsultaServidor("SELECT * FROM TB_SERVIDOR WHERE CDSERVIDOR = " + "'" + cdHostname + "'");
        if(cdHostname.equals(dados.getResultNoHostname())){
            noHostname = dados.getResultNoHostname();
            portaServidor = Integer.parseInt(dados.getResulPortaServidor());
            nomeServidor = dados.getNomeServidor();
            
        }else{
            throw new ServerNotFoundException("Erro");
        }
        
        //noHostname = dados.getResultNoHostname();
        //portaServidor = Integer.parseInt(dados.getResulPortaServidor());
    }
    
                
        
}
