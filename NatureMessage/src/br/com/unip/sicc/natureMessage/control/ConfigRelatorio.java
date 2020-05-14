package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.viewer.Componentes;
import br.com.unip.sicc.natureMessage.viewer.TelaLogin;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConfigRelatorio {
    
    
    private String nome;
    private String autor;
    private String empresa;
    private String dataCriacao;
    private String Observacao;
    private String situacaoEmpresa;
    public String [] relatorio;
    
    public ConfigRelatorio(String empresa,String observacao){
        this.empresa = empresa;
        this.Observacao = observacao;
    }
    
    public String[] montaRelatorio(String [] dadosRelatorio){
        this.nome = nomeRelatorio(TelaLogin.nomeUsuario, dadosRelatorio[0], Componentes.dataHoraAtual());
        this.autor = TelaLogin.nomeUsuario;
        this.empresa = dadosRelatorio[0];
        this.dataCriacao = Componentes.dataHoraAtual();
        this.Observacao = dadosRelatorio[1];
        
        
        return relatorio;
    }
    
    public String situacaoEmpresa(int avaliacao){
        
        if(avaliacao <=30){
            return "RUIM";
        }else if(avaliacao > 30 && avaliacao <=60){
            return "SATISFATORIO";
        }else{
            return "EXCELENTE";
        }
    }
    
    public String nomeRelatorio(String nome,String empresa,String data){
        String nomeRelatorio = "RL" + empresa + data;
        return nomeRelatorio;
    }
    
    
    
    
    

    
    
}
