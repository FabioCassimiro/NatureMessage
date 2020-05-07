package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelPadrao extends JPanel {

    private Componentes componentes = new Componentes();

    public PainelPadrao() {
        montaPainelPadrao();
    }

    public  void montaPainelPadrao() {

        JLabel btnFechar = new JLabel("X");
        btnFechar.setForeground(Color.WHITE);
        btnFechar.setFont(new Font("Arial", Font.BOLD, 25));
        btnFechar.setBounds(870, 10, 25, 25);
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });

        JButton btnInfo = Componentes.montaBotaoIcone(componentes.buscaImagem("informacao.png"), 866, 466, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaSobre();
            }
        });

        JLabel lblDesenvolvimento = Componentes.montaTexto("DESENVOLVIDO POR ALUNOS DA UNIVERSIDADE PAULISTA (UNIP)", 10, Color.WHITE, 285, 468, 350, 15);
        lblDesenvolvimento.setFont(new Font("Arial", Font.PLAIN, 10));
        this.add(lblDesenvolvimento);
        this.add(Componentes.montaTexto("NATURE", 10, Color.WHITE, 406, 451, 250, 15));
        this.add(Componentes.montaTexto("MESSAGE", 10, Color.WHITE, 451, 451, 250, 15));
        this.add(Componentes.montaSeparadora(123, 466, 650, 1));
        this.add(btnInfo);
        this.add(btnFechar);
        this.setLayout(null);
        this.setBackground(new Color(138, 43, 226));

    }
    
}