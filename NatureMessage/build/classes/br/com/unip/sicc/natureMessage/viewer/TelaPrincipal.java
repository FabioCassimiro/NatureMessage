package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame{
      
    PainelPadrao painelInicial = new PainelPadrao();
    JFrame telaPrincipal = new JFrame();
    
    public TelaPrincipal() {
        telaPrincipal.add(montaPainelInicial());
	telaPrincipal.setSize(900, 500);
        telaPrincipal.setLocationRelativeTo(null);
	telaPrincipal.setUndecorated(true);
        telaPrincipal.setVisible(true);
    }    
       
    public JPanel montaPainelInicial() {
        
        
        return painelInicial;
    }
}
