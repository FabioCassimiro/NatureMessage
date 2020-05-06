package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaBiografia {
    
    private PainelPadrao pnlBiografia = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private JFrame telaBiografia = new JFrame();

    public TelaBiografia(String aluno) {
        telaBiografia.add(montaBiografiaAluno(aluno));
        telaBiografia.setSize(900, 500);
        telaBiografia.setLocationRelativeTo(null);
        telaBiografia.setUndecorated(true);
        telaBiografia.setVisible(true);
    }

    public JPanel montaBiografiaAluno(String aluno) {
        
        String sobrenome = null;
        
        switch (aluno) {
            case "Fabio":
                sobrenome = " Cassimiro";
                break;
            case "Walisson":
                sobrenome = " Carvalho Ferreira";
                break;
            case "Daniel":
                sobrenome = " Cruz";
                break;
            case "Joao":
                sobrenome = " Algo";
                break;
            case "Marcos":
                sobrenome = " Algo";
                break;
            default:
                break;
        }
        
       
        JLabel imgAluno = new JLabel();
        imgAluno.setIcon(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/" + aluno + ".jpeg"));
        imgAluno.setBounds(50, 50, 90, 125);
        

        JButton btnVoltar = Componentes.montaBotaoIcone(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/setaVoltar.png"), 15, 10, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaBiografia.dispose();
            }
        });
        
        pnlBiografia.add(Componentes.montaTexto(aluno.toUpperCase() + sobrenome.toUpperCase(), 20, Color.WHITE, 150, 15, 500, 100));
        pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 178, 100, 100));
        pnlBiografia.add(imgAluno);
        pnlBiografia.add(btnVoltar);
        
        return pnlBiografia;
    }

    public static String montaFrase(String nome) {
        
        String frase = null;
        
        switch (nome) {
            case "Fabio":
                frase = "<html>"
                        + "fullstack<br>"
                        + "teste<br>"
                        + "de<br>"
                        + "qtde<br>"
                        + "de<br>"
                        + "linha</html>";
                //não coube
                break;
            case "Walisson":
                frase = "algo";
                break;
            case "Daniel":
                frase = "algo";
                break;
            case "Joao":
                frase = "algo";
                break;
            case "Marcos":
                frase = "algo";
                break;
        }
        return frase;
    }
}