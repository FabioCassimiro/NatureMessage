package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaSobre {

    PainelPadrao painelSobre = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();
    JFrame telaSobre = new JFrame();

    Font fonte = new Font("Arial", Font.BOLD, 15);
    
    ImageIcon imagemInstagram = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/instagram.png"));
    JLabel mostraInstagram = new JLabel(imagemInstagram);
    
    ImageIcon imagemGit = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/github.png"));
    JLabel mostraGit = new JLabel(imagemGit);
    
    public JButton btnInstagramWalisson;
    public JButton btnGitHubWalisson;
    public JButton btnInstagramFabio;
    public JButton btnGitHubFabio;

    public TelaSobre() {
        telaSobre.add(montaPainelSobre());
        telaSobre.setSize(900, 500);
        telaSobre.setLocationRelativeTo(null);
        telaSobre.setUndecorated(true);
        telaSobre.setVisible(true);
    }

    public JPanel montaPainelSobre() {

        JLabel txtLblTexto = new JLabel("SOBRE");
        txtLblTexto.setForeground(Color.WHITE);
        txtLblTexto.setFont(new Font("Arial", Font.BOLD, 25));
        txtLblTexto.setBounds(400, 50, 350, 100);

        JLabel txtLblDev = new JLabel("SOFTWARE DESEVOLVIDO POR:");
        txtLblDev.setForeground(Color.WHITE);
        txtLblDev.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblDev.setBounds(330, 70, 350, 100);
        
        JLabel txtLblFull = new JLabel("FULLSTACK:");
        txtLblFull.setForeground(Color.WHITE);
        txtLblFull.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblFull.setBounds(290, 100, 350, 100);
        
        JLabel txtLblAlunoUm = new JLabel("Fabio Cassimiro  RA:");
        txtLblAlunoUm.setForeground(Color.WHITE);
        txtLblAlunoUm.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblAlunoUm.setBounds(390, 100, 350, 100);
        
        JLabel txtLblFront = new JLabel("FRONT-END/DESIGN:");
        txtLblFront.setForeground(Color.WHITE);
        txtLblFront.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblFront.setBounds(227, 120, 350, 100);
        
        JLabel txtLblAlunoDois = new JLabel("Walisson Carvalho Ferreira  RA: D62EBA-0");
        txtLblAlunoDois.setForeground(Color.WHITE);
        txtLblAlunoDois.setFont(new Font("Arial", Font.BOLD, 15));
        txtLblAlunoDois.setBounds(390, 120, 350, 100);
        
        btnInstagramWalisson = new JButton();
        btnInstagramWalisson.setBounds(480, 170, 40, 40);
        btnInstagramWalisson.setBorder(null);
        btnInstagramWalisson.setBackground(null);
        btnInstagramWalisson.setForeground(null);
        btnInstagramWalisson.setContentAreaFilled(false);
        btnInstagramWalisson.setIcon(imagemInstagram);
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
        btnGitHubWalisson.setIcon(imagemGit);
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
        btnInstagramFabio.setIcon(imagemInstagram);
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
        btnGitHubFabio.setIcon(imagemGit);
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
        });

        /*JLabel btnOkay = new JLabel("OK");
        btnOkay.setForeground(Color.WHITE);
        btnOkay.setFont(new Font("Arial", Font.BOLD, 20));
        btnOkay.setBounds(120, 80, 100, 25);
        btnOkay.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    Runtime.getRuntime().exec("cmd.exe /C start " + "https://www.google.com/");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        JLabel txtLblTexto = new JLabel("Nome:");
        txtLblTexto.setForeground(Color.WHITE);
        txtLblTexto.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblTexto.setBounds(29, 33, 350, 32);
        
        try { 
        Runtime.getRuntime().exec("cmd.exe /C start " + "http://www.seusite.com/");
        } catch (IOException ex) { System.out.println(ex.getMessage()); }
        
        
         */
        painelSobre.add(txtLblTexto);
        painelSobre.add(txtLblDev);
        painelSobre.add(txtLblFull);
        painelSobre.add(txtLblAlunoUm);
        painelSobre.add(txtLblFront);
        painelSobre.add(txtLblAlunoDois);
        painelSobre.add(btnInstagramWalisson);
        painelSobre.add(btnGitHubWalisson);
        painelSobre.add(btnInstagramFabio);
        painelSobre.add(btnGitHubFabio);

        return painelSobre;
    }
}
