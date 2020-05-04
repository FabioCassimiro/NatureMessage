package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial {

    private PainelPadrao pnlInicial = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private JFrame telaInicial = new JFrame();

    public TelaInicial() {
        telaInicial.setSize(900, 500);
        telaInicial.add(montaPainelInicial());
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
    }

    public JPanel montaPainelInicial() {

        JLabel lblLogo = Componentes.montaTexto("", 35, Color.WHITE, 340, 120, 250, 250);
        lblLogo.setIcon(componentes.buscaImagem("/br/com/unip/sicc/natureMessage/image/logo.png"));

        pnlInicial.add(Componentes.montaTexto("NATURE", 35, Color.WHITE, 378, 100, 350, 32));
        pnlInicial.add(Componentes.montaTexto("MESSAGE", 22, Color.WHITE, 396, 124, 350, 32));
        pnlInicial.add(Componentes.montaSeparadora(352, 380, 200, 1));

        JButton btnInicia = componentes.montaBotaoAlteravel("Iniciar");
        btnInicia.setBounds(277, 342, 350, 30);
        btnInicia.setBackground(new Color(0, 255, 127));
        btnInicia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaInicial.dispose();
                new TelaConexao();
            }
        });

        JButton btnManual = Componentes.montaBotaoPadrao("Manual de funcionamento");
        btnManual.setBounds(378, 377, 150, 35);
        btnManual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Acao invoca manual.
            }
        });

        pnlInicial.add(btnInicia);
        pnlInicial.add(btnManual);
        pnlInicial.add(lblLogo);

        return pnlInicial;
    }
}
