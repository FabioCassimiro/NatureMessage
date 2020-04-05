package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PainelPadrao extends JPanel {

    public JButton btnInfo;
    
    ImageIcon imagemInfo = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/informacao.png"));
    JLabel mostraImageInfo = new JLabel(imagemInfo);

    public PainelPadrao() {
        this.setLayout(null);
        this.setBackground(new Color(138, 43, 226));

        this.add(btnFechar());
        this.add(lnSeparator());
        this.add(lblUnip());
        this.add(lblTitulo());
        this.add(lblTituloDois());
        this.add(montaBtnInfo());
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

    public JSeparator lnSeparator() {
        JSeparator linha = new JSeparator();
        linha.setForeground(Color.WHITE);
        linha.setBounds(123, 466, 650, 1);

        return linha;
    }

    public JLabel lblUnip() {
        JLabel txtLblUnip = new JLabel("DESENVOLVIDO POR ALUNOS DA UNIVERSIDADE PAULISTA (UNIP)");
        txtLblUnip.setForeground(Color.WHITE);
        txtLblUnip.setFont(new Font("Arial", Font.PLAIN, 10));
        txtLblUnip.setBounds(285, 468, 350, 15);

        return txtLblUnip;
    }

    public JLabel lblTitulo() {
        JLabel txtLblTitulo = new JLabel("NATURE");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 10));
        txtLblTitulo.setBounds(406, 451, 250, 15);

        return txtLblTitulo;
    }

    public JLabel lblTituloDois() {
        JLabel txtLblTituloDois = new JLabel("MESSAGE");
        txtLblTituloDois.setForeground(Color.WHITE);
        txtLblTituloDois.setFont(new Font("Arial", Font.PLAIN, 10));
        txtLblTituloDois.setBounds(451, 451, 250, 15);

        return txtLblTituloDois;
    }

    public JButton montaBtnInfo() {
        btnInfo = new JButton();
        btnInfo.setBounds(866, 466, 25, 25);
        btnInfo.setBorder(null);
        btnInfo.setBackground(null);
        btnInfo.setForeground(null);
        btnInfo.setContentAreaFilled(false);
        btnInfo.setIcon(imagemInfo);
        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaSobre();
            }
        });

        return btnInfo;
    }
}
