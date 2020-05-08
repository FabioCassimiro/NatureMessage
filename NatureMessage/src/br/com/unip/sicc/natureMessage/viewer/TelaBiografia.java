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

        JLabel imgAluno = new JLabel();
        imgAluno.setIcon(componentes.buscaImagem(aluno + ".jpeg"));
        imgAluno.setBounds(50, 50, 90, 125);

        JButton btnVoltar = Componentes.montaBotaoIcone(componentes.buscaImagem("setaVoltar.png"), 15, 10, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaBiografia.dispose();
            }
        });

        pnlBiografia.add(Componentes.montaSeparadora(150, 75, 350, 1));
        pnlBiografia.add(Componentes.montaTexto(aluno.toUpperCase() + montaSobrenome(aluno).toUpperCase(), 20, Color.WHITE, 150, 10, 500, 100));
        
        switch (aluno) {
            case "Daniel":         
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 80, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br> "
                        + "Desenvolvimento da documentação</html>", 15, Color.WHITE, 150, 30, 400, 150));
                break;
            case "Walisson":
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 95, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br> "
                        + "Desenvolvimento do software, front-end/design</html>", 15, Color.WHITE, 150, 30, 400, 150));
                break;
            case "Fabio":
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 80, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br> "
                        + "Desenvolvimento do software, front-end/back-end</html>", 15, Color.WHITE, 150, 30, 400, 150));
                break;
        }

        //singleton - somente uma instancia
        
        pnlBiografia.add(imgAluno);
        pnlBiografia.add(btnVoltar);

        return pnlBiografia;
    }

    public static String montaFrase(String nome) {

        String frase = null;

        switch (nome) {
            case "Fabio":
                frase = "<html></html>";
                break;
            case "Walisson":
                frase = "<html>Meu nome é Walisson, tenho 19 anos, e sou estudante"
                        + " de Ciência da Computação. Atualmente trabalho na Ericsson, atuando como"
                        + " desenvolvedor de testes (QA - Quality Assurance).<br><br>"
                        + "\"Diante da vastidão do tempo e da imensidão do universo, é um imenso prazer para mim dividir um planeta e uma época com vocês.\"<br>"
                        + "Sagan, Carl 05/2020</html>";
                break;
            case "Daniel":
                frase = "<html>Meu nome é Daniel, tenho 20 anos, e sou estudante"
                        + " de Ciência da Computação. Atualmente trabalho na Ericsson, atuando como"
                        + " desenvolvedor RPA.<br><br>"
                        + "\"Quanto mais certeza temos de quem somos, menos importa o que pensam sobre quem a gente é.\"   <br>"
                        + ".&emsp; 05/2020</html>";
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

    public static String montaSobrenome(String nome) {

        String sobrenome = null;

        switch (nome) {
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

        return sobrenome;
    }
}
