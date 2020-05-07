package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.exception.ServerNotFoundException;
import br.com.unip.sicc.natureMessage.viewer.Componentes;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigConexaoServidor {

    private String noHostname;
    private int portaServidor;
    private String nomeServidor;
    private AcoesBancoDeDados dados = new AcoesBancoDeDados();
    private Componentes componentes = new Componentes();
    String [] camposServidor = {"CDSERVIDOR"};
    
    
    public String getNoHostname() {
        return noHostname;
    }

    public int getPortaServidor() {
        return portaServidor;
    }

    public String getNomeServidor() {
        return nomeServidor;
    }

    public void ValidaServidor(String cdHostname) throws ServerNotFoundException {
        String [] dadosServidor = {cdHostname};
        dados.ConsultaServidor(AcoesBancoDeDados.comandoSelect(camposServidor, dadosServidor, "TB_SERVIDOR"));
        if (cdHostname.equals(AcoesBancoDeDados.resultCdServidor)) {
           // noHostname = dados.getResultNoHostname();
            portaServidor = Integer.parseInt(AcoesBancoDeDados.resulPtServidor);
            nomeServidor = AcoesBancoDeDados.resultNoServidor;

        } else {
            componentes.montaMensagemAviso("Servidor nao encontrado", "ERRO");
            throw new ServerNotFoundException("Erro de SQL");

        }

    }

}
