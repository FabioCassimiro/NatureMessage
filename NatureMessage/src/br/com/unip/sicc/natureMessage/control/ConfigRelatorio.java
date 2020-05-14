package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.viewer.Componentes;
import br.com.unip.sicc.natureMessage.viewer.TelaLogin;

public class ConfigRelatorio {
    
    
    private static String nome;
    private static String dataCriacao;
    private static String situacaoEmpresa;

    
    public static void montaRelatorio( String empresa, int avaliacao, String observacao){
        nome = nomeRelatorio(empresa, TelaLogin.nomeUsuario);
        situacaoEmpresa = situacaoEmpresa(avaliacao);
        dataCriacao = Componentes.dataHoraAtual();
        String [] relatorio = {nome,TelaLogin.nomeUsuario,empresa,dataCriacao,situacaoEmpresa,observacao};
        AcoesBancoDeDados.comandoInsert(relatorio, "TB_RELATORIO");
    }
    
    
    public static String situacaoEmpresa(int avaliacao){
        
        if(avaliacao <=30){
            return "RUIM";
        }else if(avaliacao > 30 && avaliacao <=60){
            return "SATISFATORIO";
        }else{
            return "EXCELENTE";
        }
    }
    
    public static String nomeRelatorio(String empresa,String data){
        String nomeRelatorio = "RL" + empresa.trim() + data;
        return nomeRelatorio;
    }
    
    
    
    
    

    
    
}
