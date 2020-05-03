package br.com.unip.sicc.natureMessage.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class PainelPadrao extends JPanel {

    private Componentes componentes = new Componentes();

    public PainelPadrao() {
        this.setLayout(null);
        this.setBackground(new Color(138, 43, 226));
        this.add(btnFechar());
        this.add(montaBtnInfo());
        montaRodaPe();
    }

    public JLabel btnFechar() {
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

        return btnFechar;
    }

    public void montaRodaPe() {

        JLabel lblDesenvolvimento = Componentes.lblTexto("DESENVOLVIDO POR ALUNOS DA UNIVERSIDADE PAULISTA (UNIP)", 10, Color.WHITE, 285, 468, 350, 15);
        lblDesenvolvimento.setFont(new Font("Arial", Font.PLAIN, 10));
        this.add(lblDesenvolvimento);
        this.add(Componentes.lblTexto("NATURE", 10, Color.WHITE, 406, 451, 250, 15));
        this.add(Componentes.lblTexto("MESSAGE", 10, Color.WHITE, 451, 451, 250, 15));
        this.add(Componentes.linhaSeparadora(123, 466, 650, 1));
    }

    public JButton montaBtnInfo() {
        JButton btnInfo = Componentes.montaBtnPadrao("");
        btnInfo.setBounds(866, 466, 25, 25);
        btnInfo.setToolTipText("Sobre");
        btnInfo.setIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/informacao.png"));
        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaSobre();
            }
        });

        return btnInfo;
    }
}
