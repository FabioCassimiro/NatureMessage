package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaSobre {

    private PainelPadrao pnlSobre = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private JFrame telaSobre = new JFrame();

    public TelaSobre() {
        telaSobre.add(montaPainelSobre());
        telaSobre.setSize(900, 500);
        telaSobre.setLocationRelativeTo(null);
        telaSobre.setUndecorated(true);
        telaSobre.setVisible(true);
    }

    public JPanel montaPainelSobre() {

        JButton btnVoltar = Componentes.montaBotaoIcone(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/setaVoltar.png"), 15, 10, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaSobre.dispose();
            }
        });

        pnlSobre.add(Componentes.montaTexto("SOBRE", 25, Color.WHITE, 400, 50, 350, 100));

        String apresentacao = "<html>Esse programa tem como principal objetivo estabelecer a comunicação <br>"
                + "entre duas ou mais pessoas conectadas a um mesmo servidor, e <br>"
                + "principalmente trazer à visibilidade de como funciona a comunicação entre <br>"
                + "clientes e servidores através da rede, utilizando os sockets de Berkeley.</html>";

        pnlSobre.add(Componentes.montaTexto(apresentacao, 15, Color.WHITE, 208, 10, 1000, 300));

        JLabel imgFabio = new JLabel();
        imgFabio.setIcon(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/Fabio.jpeg"));
        imgFabio.setBounds(195, 300, 90, 125);
        imgFabio.setToolTipText("<html>\"Cada adversidade, cada fracasso, cada dor<br>"
                + " de cabeça carrega consigo a semente<br>"
                + " de um benefício igual ou maior.\"</html>");

        JLabel imgWalisson = new JLabel();
        imgWalisson.setIcon(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/Walisson.jpg"));
        imgWalisson.setBounds(305, 300, 90, 125);
        imgWalisson.setToolTipText("Isso ai é detalhe.");

        JLabel imgJoao = new JLabel();
        imgJoao.setIcon(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/Joao.jpeg"));
        imgJoao.setBounds(415, 300, 90, 125);
        imgJoao.setToolTipText("<html>\"Perder Tempo aprendendo coisas que não nos<br>"
                + "interessam, priva-nos de aprender coisas interessantes\".</html>");

        JLabel imgDaniel = new JLabel();
        imgDaniel.setIcon(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/Daniel.jpeg"));
        imgDaniel.setBounds(525, 300, 90, 125);
        imgDaniel.setToolTipText("<html>\"Quanto mais certeza temos de quem somos,<br>"
                + " menos importa o que pensam sobre quem a gente é\".</html>");

        JLabel imgMarcos = new JLabel();
        imgMarcos.setIcon(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/Marcos.jpeg"));
        imgMarcos.setBounds(635, 300, 90, 125);
        imgMarcos.setToolTipText("<html>\"Aos outros, dou o direito de ser como são.<br>"
                + "A mim, dou o dever de ser cada dia melhor\".</html>");

        pnlSobre.add(imgMarcos);
        pnlSobre.add(imgJoao);
        pnlSobre.add(imgWalisson);
        pnlSobre.add(imgFabio);
        pnlSobre.add(imgDaniel);
        pnlSobre.add(btnVoltar);

        return pnlSobre;
    }
}
