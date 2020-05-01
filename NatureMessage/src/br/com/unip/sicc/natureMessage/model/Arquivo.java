package br.com.unip.sicc.natureMessage.model;

import java.io.Serializable;

public class Arquivo implements Serializable {

    private String nomeArquivo;
    private byte[] arquivo;
    private transient long tamanhoArquivo;
    private transient String ipservidor;
    private transient int portaServidor;

    private static final long serialVersionUID = 1L;

    public Arquivo(String nomeArquivo, byte[] arquivo, long tamanhoArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
        this.arquivo = arquivo;
    }


}
