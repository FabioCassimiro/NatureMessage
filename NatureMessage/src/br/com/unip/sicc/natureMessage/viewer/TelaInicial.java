package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class TelaInicial {

    private PainelPadrao pnlInicial = new PainelPadrao();
    private BotoesPadrao botoesPadrao = new BotoesPadrao();
    private JFrame telaInicial = new JFrame();
    private JLabel lblLogo;
    private JButton btnInicia;
    private JLabel lblTitulo;
    private JLabel lblSubTitulo;
    private JButton btnManual;
    private JSeparator lnsManual;
    private ImageIcon imgCompartilhar = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/logo.png"));
    private JLabel lblCompartilhar = new JLabel(imgCompartilhar);

    public TelaInicial() {
        telaInicial.setSize(900, 500);
        telaInicial.add(montaPainelInicial());
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
    }

    public JPanel montaPainelInicial() {
        
        lblLogo = new JLabel();
        lblLogo.setBounds(340, 120, 250, 250);
        lblLogo.setBorder(null);
        lblLogo.setBackground(null);
        lblLogo.setForeground(null);
        lblLogo.setIcon(imgCompartilhar);

        lblTitulo = new JLabel("NATURE");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        lblTitulo.setBounds(378, 100, 350, 32);

        lblSubTitulo = new JLabel("MESSAGE");
        lblSubTitulo.setForeground(Color.WHITE);
        lblSubTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblSubTitulo.setBounds(396, 124, 350, 32);

        btnInicia = new JButton();
        btnInicia = botoesPadrao.montaBtnAlteravel();
        btnInicia.setText("Iniciar");
        btnInicia.setBounds(277, 342, 350, 30);
        btnInicia.setBackground(new Color(0, 255, 127));
        btnInicia.setForeground(Color.WHITE);
        btnInicia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaInicial.dispose();
                new TelaLogin();
            }
        });
        
        btnManual = new JButton();
        btnManual = botoesPadrao.montaBtnPadrao();
        btnManual.setText("Manual de funcionamento");
        btnManual.setForeground(Color.WHITE);
        btnManual.setFont(new Font("Arial", Font.BOLD, 12));
        btnManual.setBounds(378, 377, 150, 35);
        btnManual.setContentAreaFilled(false);
        btnManual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        lnsManual = new JSeparator();
        lnsManual.setForeground(Color.WHITE);
        lnsManual.setBounds(352, 380, 200, 1);

        pnlInicial.add(btnInicia);
        pnlInicial.add(lblTitulo);
        pnlInicial.add(lblSubTitulo);
        pnlInicial.add(btnManual);
        pnlInicial.add(lnsManual);
        pnlInicial.add(lblLogo);

        return pnlInicial;
    }
}
