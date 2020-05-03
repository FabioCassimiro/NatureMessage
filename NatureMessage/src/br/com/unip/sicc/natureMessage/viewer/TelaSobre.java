package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaSobre {

    private PainelPadrao pnlSobre = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private JFrame telaSobre = new JFrame();
    private Font fonte = new Font("Arial", Font.BOLD, 15);
    private ImageIcon imgIntagram = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/instagram.png"));
    private ImageIcon imgGit = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/github.png"));
    private JButton btnInstagramWalisson;
    private JButton btnGitHubWalisson;
    private JButton btnInstagramFabio;
    private JButton btnGitHubFabio;
    private JLabel lblAlunoDois;
    private JLabel lblFront;
    private JLabel lblAlunoUm;
    private JLabel lblFull;
    private JLabel lblDev;
    private JLabel lblTexto;
    private JButton btnVoltar;
    private ImageIcon imagemVoltar = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/setaVoltar.png"));
    private JLabel mostraVoltar = new JLabel(imagemVoltar);

    public TelaSobre() {
        telaSobre.add(montaPainelSobre());
        telaSobre.setSize(900, 500);
        telaSobre.setLocationRelativeTo(null);
        telaSobre.setUndecorated(true);
        telaSobre.setVisible(true);
    }

    public JPanel montaPainelSobre() {


        btnVoltar = Componentes.btnIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/setaVoltar.png"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaSobre.dispose();
            };
            
        });

        lblTexto = new JLabel("SOBRE");
        lblTexto.setForeground(Color.WHITE);
        lblTexto.setFont(new Font("Arial", Font.BOLD, 25));
        lblTexto.setBounds(400, 50, 350, 100);

        /*lblDev = new JLabel("SOFTWARE DESEVOLVIDO POR:");
        lblDev.setForeground(Color.WHITE);
        lblDev.setFont(new Font("Arial", Font.BOLD, 15));
        lblDev.setBounds(330, 70, 350, 100);

        lblFull = new JLabel("FULLSTACK:");
        lblFull.setForeground(Color.WHITE);
        lblFull.setFont(new Font("Arial", Font.BOLD, 15));
        lblFull.setBounds(290, 100, 350, 100);

        lblAlunoUm = new JLabel("Fabio Cassimiro  RA: N359838");
        lblAlunoUm.setForeground(Color.WHITE);
        lblAlunoUm.setFont(new Font("Arial", Font.BOLD, 15));
        lblAlunoUm.setBounds(390, 100, 350, 100);*/
         
        String apresentacao = "<html>Esse programa tem como principal objetivo estabelecer a comunicação <br>"
                + "entre duas ou mais pessoas conectadas a um mesmo servidor, e <br>"
                + "principalmente trazer à visibilidade de como funciona a comunicação entre <br>"
                + "clientes e servidores através da rede, utilizando os sockets de Berkeley.</html>";
      
        pnlSobre.add(Componentes.lblTexto(apresentacao, 15, Color.white, 208, 10, 1000,300));
        componentes.image("/br/com/unip/sicc/natureMessage/image/setaVoltar.png");
        
        JLabel imgFabio = new JLabel();
        imgFabio.setIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/Fabio.jpeg"));
        imgFabio.setBounds(100, 200, 90, 125);
        
        JLabel imgDaniel = new JLabel();
        imgFabio.setIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/Daniel.jpeg"));
        imgFabio.setBounds(300, 200, 90, 125);
        
        
        pnlSobre.add(imgFabio);
        pnlSobre.add(imgDaniel);
        
        
        //pnlSobre.add(Componentes.lblTexto("FRONT-END/DESIGN:", 15, Color.WHITE, 227, 120, 350, 100));

        //pnlSobre.add(Componentes.lblTexto("Walisson Carvalho Ferreira  RA: D62EBA0", 15, Color.WHITE, 390, 120, 350, 100));

        /*btnInstagramWalisson = new JButton();
        btnInstagramWalisson.setBounds(480, 170, 40, 40);
        btnInstagramWalisson.setBorder(null);
        btnInstagramWalisson.setBackground(null);
        btnInstagramWalisson.setForeground(null);
        btnInstagramWalisson.setContentAreaFilled(false);
        btnInstagramWalisson.setIcon(imgIntagram);
        btnInstagramWalisson.setToolTipText("Walisson");
        btnInstagramWalisson.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    Runtime.getRuntime().exec("cmd.exe /C start " + "https://www.instagram.com/walisoull/");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        btnGitHubWalisson = new JButton();
        btnGitHubWalisson.setBounds(505, 170, 40, 40);
        btnGitHubWalisson.setBorder(null);
        btnGitHubWalisson.setBackground(null);
        btnGitHubWalisson.setForeground(null);
        btnGitHubWalisson.setContentAreaFilled(false);
        btnGitHubWalisson.setIcon(imgGit);
        btnGitHubWalisson.setToolTipText("Walisson");
        btnGitHubWalisson.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    Runtime.getRuntime().exec("cmd.exe /C start " + "https://github.com/WalissonCF");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        btnInstagramFabio = new JButton();
        btnInstagramFabio.setBounds(330, 170, 40, 40);
        btnInstagramFabio.setBorder(null);
        btnInstagramFabio.setBackground(null);
        btnInstagramFabio.setForeground(null);
        btnInstagramFabio.setContentAreaFilled(false);
        btnInstagramFabio.setIcon(imgIntagram);
        btnInstagramFabio.setToolTipText("Fabio");
        btnInstagramFabio.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    Runtime.getRuntime().exec("cmd.exe /C start " + "https://www.instagram.com/");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        btnGitHubFabio = new JButton();
        btnGitHubFabio.setBounds(355, 170, 40, 40);
        btnGitHubFabio.setBorder(null);
        btnGitHubFabio.setBackground(null);
        btnGitHubFabio.setForeground(null);
        btnGitHubFabio.setContentAreaFilled(false);
        btnGitHubFabio.setIcon(imgGit);
        btnGitHubFabio.setToolTipText("Fabio");
        btnGitHubFabio.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    Runtime.getRuntime().exec("cmd.exe /C start " + "https://github.com/");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });*/

        pnlSobre.add(btnVoltar);
        pnlSobre.add(lblTexto);
        /*pnlSobre.add(lblDev);
        pnlSobre.add(lblFull);
        pnlSobre.add(lblAlunoUm);*/

        /*pnlSobre.add(btnInstagramWalisson);
        pnlSobre.add(btnGitHubWalisson);
        pnlSobre.add(btnInstagramFabio);
        pnlSobre.add(btnGitHubFabio);*/

        return pnlSobre;
    }
}
