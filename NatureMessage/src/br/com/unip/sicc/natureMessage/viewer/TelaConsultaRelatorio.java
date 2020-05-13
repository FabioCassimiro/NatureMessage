package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TelaConsultaRelatorio {
    
    
    private JEditorPane txaRelatorio;
    PainelPadrao pnlConsultaRelatorio = new PainelPadrao();
    JFrame telaConsultaRelatorio = new JFrame();
    public String [] relatorio;
    
    public TelaConsultaRelatorio() {
        telaConsultaRelatorio.add(montaPainelConsultaRelatorio());
        telaConsultaRelatorio.setSize(900, 500);
        telaConsultaRelatorio.setLocationRelativeTo(null);
        telaConsultaRelatorio.setUndecorated(true);
        telaConsultaRelatorio.setVisible(true);
    }
    
    public JPanel montaPainelConsultaRelatorio() {
        String engajamento = "Nivel de enjamento ambiental";
        
        pnlConsultaRelatorio.add(Componentes.montaTexto("Relatório", 35, Color.WHITE, 370, 0, 350, 50));
        
        JScrollPane scrollRelatorio = new JScrollPane(txaRelatorio = new JEditorPane());
        txaRelatorio.setEditable(true);
        txaRelatorio.setFont(new Font("Arial", Font.PLAIN, 14));
        scrollRelatorio.setBounds(50, 70, 600, 200); 
        
        JButton btnEnviar = Componentes.montaBotaoAlteravel("Enviar");
        btnEnviar.setBounds(771, 390, 79, 35);
        btnEnviar.setBackground(new Color(0, 255, 127));
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JButton btnLimpar = Componentes.montaBotaoAlteravel("Limpar");
        btnLimpar.setBounds(680, 390, 79, 35);
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("limpas");
            }
        });
        
        JButton btnConsultar = Componentes.montaBotaoAlteravel("Consultar");
        btnConsultar.setBounds(150, 390, 79, 35);
        btnConsultar.setBackground(new Color(255, 215, 0));
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
 
        pnlConsultaRelatorio.add(Componentes.montaTexto("Empresa: ", 12, Color.WHITE, 44, 33, 350, 20));
        JTextField txfEmpresa = Componentes.montaTxfPadrao(45, 60, 300, 25);
        pnlConsultaRelatorio.add(txfEmpresa);
        pnlConsultaRelatorio.add(Componentes.montaSeparadora(45, 85, 300, 1));
        
        
     
        pnlConsultaRelatorio.add(btnConsultar);
        pnlConsultaRelatorio.add(btnEnviar);
        pnlConsultaRelatorio.add(btnLimpar);
        
        return pnlConsultaRelatorio;
    }
    
    
}
