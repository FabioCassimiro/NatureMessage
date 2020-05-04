package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

        JButton btnInfo = Componentes.btnIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/informacao.png"), 866, 466, 25, 25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaSobre();
            }
        });

        JLabel lblDesenvolvimento = Componentes.lblTexto("DESENVOLVIDO POR ALUNOS DA UNIVERSIDADE PAULISTA (UNIP)", 10, Color.WHITE, 285, 468, 350, 15);
        lblDesenvolvimento.setFont(new Font("Arial", Font.PLAIN, 10));
        this.add(lblDesenvolvimento);
        this.add(Componentes.lblTexto("NATURE", 10, Color.WHITE, 406, 451, 250, 15));
        this.add(Componentes.lblTexto("MESSAGE", 10, Color.WHITE, 451, 451, 250, 15));
        this.add(Componentes.linhaSeparadora(123, 466, 650, 1));
        this.add(btnInfo);
        this.add(btnFechar);
        this.setLayout(null);
        this.setBackground(new Color(138, 43, 226));

    }

    /*

   public JButton montaBtnInfo() {
        

        return btnInfo;
    }*/
}
