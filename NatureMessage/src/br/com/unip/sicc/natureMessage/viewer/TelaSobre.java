package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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

        JButton btnVoltar = Componentes.montaBotaoIcone(componentes.buscaImagem("setaVoltar.png"), 15, 10, 25, 25, new ActionListener() {
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

        JButton imgFabio = new JButton();
        imgFabio.setIcon(componentes.buscaImagem("Fabio.jpeg"));
        imgFabio.setBounds(195, 300, 90, 125);
        imgFabio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaBiografia fabio = new TelaBiografia("Fabio");
                //telaSobre.dispose();
            }
        });

        JButton imgWalisson = new JButton();
        imgWalisson.setIcon(componentes.buscaImagem("Walisson.jpg"));
        imgWalisson.setBounds(305, 300, 90, 125);
        imgWalisson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaBiografia walisson = new TelaBiografia("Walisson");
            }
        });

        JButton imgJoao = new JButton();
        imgJoao.setIcon(componentes.buscaImagem("Joao.jpeg"));
        imgJoao.setBounds(415, 300, 90, 125);
        imgJoao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaBiografia joao = new TelaBiografia("Joao");
            }
        });

        JButton imgDaniel = new JButton();
        imgDaniel.setIcon(componentes.buscaImagem("Daniel.jpeg"));
        imgDaniel.setBounds(525, 300, 90, 125);
        imgDaniel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaBiografia daniel = new TelaBiografia("Daniel");
            }
        });

        JButton imgMarcos = new JButton();
        imgMarcos.setIcon(componentes.buscaImagem("Marcos.jpeg"));
        imgMarcos.setBounds(635, 300, 90, 125);
        imgMarcos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaBiografia marcos = new TelaBiografia("Marcos");
            }
        });

        pnlSobre.add(imgMarcos);
        pnlSobre.add(imgJoao);
        pnlSobre.add(imgWalisson);
        pnlSobre.add(imgFabio);
        pnlSobre.add(imgDaniel);
        pnlSobre.add(btnVoltar);

        return pnlSobre;
    }
}
