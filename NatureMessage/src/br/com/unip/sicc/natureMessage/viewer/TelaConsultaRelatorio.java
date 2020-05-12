package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.control.ConfigChat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaConsultaRelatorio {
    
    Componentes componentes = new Componentes();
    PainelPadrao pnlConsultaRelatorio = new PainelPadrao();
    Componentes botoesPadrao = new Componentes();
    
    private JEditorPane txaRelatorio;
    
    JFrame telaConsultaRelatorio = new JFrame();
    
    public TelaConsultaRelatorio() {
        telaConsultaRelatorio.add(montaPainelConsultaRelatorio());
        telaConsultaRelatorio.setSize(900, 500);
        telaConsultaRelatorio.setLocationRelativeTo(null);
        telaConsultaRelatorio.setUndecorated(true);
        telaConsultaRelatorio.setVisible(true);
    }
    
    public JPanel montaPainelConsultaRelatorio() {
    
        JScrollPane scrollRelatorio = new JScrollPane(txaRelatorio = new JEditorPane());
        txaRelatorio.setEditable(true);
        txaRelatorio.setFont(new Font("Arial", Font.PLAIN, 14));
        scrollRelatorio.setBounds(50, 70, 800, 300); 
        
        JButton btnEnviar = botoesPadrao.montaBotaoAlteravel("Enviar");
        btnEnviar.setBounds(771, 390, 79, 35);
        btnEnviar.setBackground(new Color(0, 255, 127));
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JButton btnLimpar = botoesPadrao.montaBotaoAlteravel("Limpar");
        btnLimpar.setBounds(680, 390, 79, 35);
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JButton btnConsultar = botoesPadrao.montaBotaoAlteravel("Limpar");
        btnLimpar.setBounds(680, 390, 79, 35);
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        pnlConsultaRelatorio.add(scrollRelatorio);
        pnlConsultaRelatorio.add(btnEnviar);
        pnlConsultaRelatorio.add(btnLimpar);
        
        return pnlConsultaRelatorio;
    }
    
    
}
