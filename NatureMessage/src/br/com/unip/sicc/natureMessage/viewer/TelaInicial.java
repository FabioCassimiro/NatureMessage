package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaInicial {

    private PainelPadrao pnlInicial = new PainelPadrao();
    private Componentes componentes = new Componentes();
    private JFrame telaInicial = new JFrame();
    public static String noBanco;
    public static String noSenhaBanco;
    public static String noUsuarioBanco;
    public static String noEnderecoBanco;
    ImageIcon imagemExecute = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/execute.png"));
    ImageIcon imagemRede = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/rede.png"));

    public TelaInicial() {
        telaInicial.setSize(900, 500);
        telaInicial.add(montaPainelInicial());
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setUndecorated(true);
        telaInicial.setVisible(true);
    }

    public JPanel montaPainelInicial() {

        JLabel lblLogo = Componentes.montaTexto("", 35, Color.WHITE, 340, 120, 250, 250);
        lblLogo.setIcon(componentes.buscaImagem("logo.png"));

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
                new TelaLogin();
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
        JButton btnDAO = Componentes.montaBotaoIcone(imagemExecute, 0, 450, 50, 50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog("Digite o usuario");
                String password = JOptionPane.showInputDialog("Digite a senha");

                if (user.equals("admin") && password.equals("nature@_@125311314")) {
                    noBanco = JOptionPane.showInputDialog("Nome do Banco de dados");
                    noEnderecoBanco = JOptionPane.showInputDialog("Endereço ip do Banco de dados");
                    noUsuarioBanco = JOptionPane.showInputDialog("Nome do usuario do Banco de dados");
                    noSenhaBanco = JOptionPane.showInputDialog("Senha do Banco de dados(caso nao haja digite nulo)");
                }else{
                    JOptionPane.showMessageDialog(null, "Acesso Negado!");
                }

            }

        });

        pnlInicial.add(btnInicia);
        pnlInicial.add(btnManual);
        pnlInicial.add(lblLogo);
        pnlInicial.add(btnDAO);

        return pnlInicial;
    }
}
