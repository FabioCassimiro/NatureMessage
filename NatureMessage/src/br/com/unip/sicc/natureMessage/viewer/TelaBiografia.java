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
        String linkInstagram = null;
        String linkGitHub = null;

        JButton btnVoltar = Componentes.montaBotaoIcone(componentes.buscaImagem("setaVoltar.png"), 15, 10, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaBiografia.dispose();
            }
        });

        pnlBiografia.add(Componentes.montaSeparadora(150, 75, 380, 1));
        pnlBiografia.add(Componentes.montaTexto(aluno.toUpperCase() + montaSobrenome(aluno).toUpperCase(), 20, Color.WHITE, 150, 10, 500, 100));

        switch (aluno) {
            case "Daniel":
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 85, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br> "
                        + "Desenvolvimento da documentação</html>", 15, Color.WHITE, 150, 25, 400, 150));
                break;
            case "Walisson":
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 99, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br> "
                        + "Desenvolvimento do software, front-end e design</html>", 15, Color.WHITE, 150, 25, 400, 150));
                linkInstagram = "walisoull/";
                linkGitHub = "WalissonCF";
                break;
            case "Fabio":
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 80, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br> "
                        + "Desenvolvimento do software, front-end/back-end<br>"
                        + "e documentação.</html>", 15, Color.WHITE, 150, 33, 400, 150));
                linkInstagram = "fabio_cassimiro19/";
                linkGitHub = "fabiocassimiro";
                break;
            case "Joao":
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 80, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br>"
                        + "Desenvolvimento da documentação</html>", 15, Color.WHITE, 150, 25, 400, 150));
                break;
            case "Marcos":
                pnlBiografia.add(Componentes.montaTexto(montaFrase(aluno), 15, Color.WHITE, 150, 100, 600, 300));
                pnlBiografia.add(Componentes.montaTexto("<html>Responsável por:<br>"
                        + "Desenvolvimento da documentação</html>", 15, Color.WHITE, 150, 25, 400, 150));
                break;
        }
        
        pnlBiografia.add(imgAluno);
        pnlBiografia.add(btnVoltar);
        pnlBiografia.add(componentes.redesSociais("INSTAGRAM", "instagram.png", linkInstagram, aluno, 40, 168, 100 ,50));
        pnlBiografia.add(componentes.redesSociais("GITHUB", "github.png", linkGitHub, aluno, 30, 195, 100, 50));

        return pnlBiografia;
    }

    public static String montaFrase(String nome) {

        String frase = null;

        switch (nome) {
            case "Fabio":
                frase = "<html>Meu nome é Fabio, tenho 19 anos, e sou estudante"
                        + " de Ciência da Computação. Atualmente faço freelancer, na area de"
                        + " TI.<br><br>"
                        + "\"Você é o unico responsável na terra por seus sucessos e fracassos.\"<br>"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp;&thinsp;&thinsp;"
                        + "&thinsp;Cassimiro, Fabio<br>"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp;&thinsp;&thinsp;Cadastrado em: 05/2020</html>";
                break;
            case "Walisson":
                frase = "<html>Meu nome é Walisson, tenho 19 anos, e sou estudante"
                        + " de Ciência da Computação. Atualmente trabalho na Ericsson, atuando como"
                        + " desenvolvedor de testes (QA - Quality Assurance).<br><br>"
                        + "\"Diante da vastidão do tempo e da imensidão do universo, é um imenso prazer para mim dividir um planeta e uma época com vocês.\"<br>"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;Sagan, Carl<br>"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  Cadastrado em: 05/2020</html>";
                break;
            case "Daniel":
                frase = "<html>Meu nome é Daniel, tenho 20 anos, e sou estudante"
                        + " de Ciência da Computação. Atualmente trabalho na Ericsson, atuando como"
                        + " desenvolvedor RPA.<br><br>"
                        + "\"Quanto mais certeza temos de quem somos, menos importa o que pensam sobre quem a gente é.\"   <br>"
                        + "&emsp; 05/2020</html>";
                break;
            case "Joao":
                frase = "<html>Meu nome é Joao, tenho 19 anos, e sou estudante"
                        + " de Ciência da Computação. Trabalho atualmente  com análise e gestão"
                        + " de dados no Bradesco.<br><br>"
                        + "\"Perder tempo aprendendo coisas que não nos interessam, priva-nos de aprender coisas interessantes.\"   <br>"
                        + "&emsp; 05/2020</html>";
                break;
            case "Marcos":
                frase = "<html>Meu nome é Marcos, tenho 29 anos, e sou estudante"
                        + " de Ciência da Computação. Atualmente trabalho como Analista de Contas"
                        + " Médicas em uma multinacional de convênio médico.<br><br>"
                        + "\"Aos outros, dou o direito de ser como são. A mim dou o dever de ser cada dia melhor.\"   <br>"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;"
                        + "&thinsp;&thinsp;&thinsp;Chico Xavier <br>"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                        + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Cadastrato em: 05/2020</html>";
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
                sobrenome = " César Silva do Nascimento";
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
