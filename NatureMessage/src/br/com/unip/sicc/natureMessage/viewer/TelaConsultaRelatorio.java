package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
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
    
    ButtonGroup grupoPerguntaUm = new ButtonGroup();
    ButtonGroup grupoPerguntaDois = new ButtonGroup();
    
    public TelaConsultaRelatorio() {
        telaConsultaRelatorio.add(montaPainelConsultaRelatorio());
        telaConsultaRelatorio.setSize(900, 500);
        telaConsultaRelatorio.setLocationRelativeTo(null);
        telaConsultaRelatorio.setUndecorated(true);
        telaConsultaRelatorio.setVisible(true);
    }
    
    public JPanel montaPainelConsultaRelatorio() {
        String engajamento = "Nivel de enjamento ambiental";
        
        pnlConsultaRelatorio.add(Componentes.montaTexto("Relatório", 35, Color.WHITE, 370, 12, 350, 50));
        
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
        
        pnlConsultaRelatorio.add(Componentes.montaTexto("<html>A empresa está reciclando os materiais que podem"
                + " ser reutilizados?</html>", 12, Color.WHITE, 44, 110, 300, 100));
        JRadioButton perguntaUmSim = Componentes.montaRadio("Sim", 44, 178);
        JRadioButton perguntaUmNao = Componentes.montaRadio("Não", 95, 178);
        grupoPerguntaUm.add(perguntaUmSim);
        grupoPerguntaUm.add(perguntaUmNao);
     
        pnlConsultaRelatorio.add(Componentes.montaTexto("<html>Quanto a empresa se mostra integrada com ações "
                + "benéficas ao meio ambiente?</html>", 12, Color.WHITE, 44, 180, 300, 100));
        JRadioButton pergutaDoisUmPonto = Componentes.montaRadio("1", 44, 250);
        JRadioButton pergutaDoisDoisPontos = Componentes.montaRadio("2", 83, 250);
        JRadioButton pergutaDoisTresPontos = Componentes.montaRadio("3", 122, 250);
        JRadioButton pergutaDoisQuatroPontos = Componentes.montaRadio("4", 160, 250);
        JRadioButton pergutaDoisCincoPontos = Componentes.montaRadio("5", 198, 250);
        grupoPerguntaDois.add(pergutaDoisUmPonto);
        grupoPerguntaDois.add(pergutaDoisDoisPontos);
        grupoPerguntaDois.add(pergutaDoisTresPontos);
        grupoPerguntaDois.add(pergutaDoisQuatroPontos);
        grupoPerguntaDois.add(pergutaDoisCincoPontos);
        
        JButton btnConsultar = Componentes.montaBotaoAlteravel("Consultar");
        btnConsultar.setBounds(150, 390, 79, 35);
        btnConsultar.setBackground(new Color(255, 215, 0));
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
 
        pnlConsultaRelatorio.add(Componentes.montaTexto("Empresa: ", 12, Color.WHITE, 44, 80, 350, 20));
        JTextField txfEmpresa = Componentes.montaTxfPadrao(45, 100, 300, 25);
        pnlConsultaRelatorio.add(txfEmpresa);
        pnlConsultaRelatorio.add(Componentes.montaSeparadora(45, 125, 300, 1));     
     
        pnlConsultaRelatorio.add(perguntaUmSim);
        pnlConsultaRelatorio.add(perguntaUmNao);
        pnlConsultaRelatorio.add(pergutaDoisUmPonto);
        pnlConsultaRelatorio.add(pergutaDoisDoisPontos);
        pnlConsultaRelatorio.add(pergutaDoisTresPontos);
        pnlConsultaRelatorio.add(pergutaDoisQuatroPontos);
        pnlConsultaRelatorio.add(pergutaDoisCincoPontos); 
        pnlConsultaRelatorio.add(btnConsultar);
        pnlConsultaRelatorio.add(btnEnviar);
        pnlConsultaRelatorio.add(btnLimpar);
        
        return pnlConsultaRelatorio;
    }
    
    
}
