package br.com.unip.sicc.natureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaChat extends JFrame {

    private Socket s;
    private BufferedReader bff;
    private InputStreamReader isr;

    public JButton btnCompartilharImagem;
    public JButton btnCompartilharDoc;
    JTextArea txaEnviar;
    JTextArea txaChat;

    //PainelChat painelChat = new PainelChat();
    PainelPadrao painelChat = new PainelPadrao();
    BotoesPadrao botoesPadrao = new BotoesPadrao();

    JFrame telaChat = new JFrame();

    public TelaChat() {
        telaChat.add(montaPainelChat());
        telaChat.setSize(900, 500);
        telaChat.setLocationRelativeTo(null);
        telaChat.setUndecorated(true);
        telaChat.setVisible(true);
        Chat();
    }

    ImageIcon imagemCompartilhar = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/compartilhar.png"));
    JLabel mostraCompartilhar = new JLabel(imagemCompartilhar);

    ImageIcon imagemCompartilharImagem = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/compartilharImagem.png"));
    JLabel mostraCompartilharImagem = new JLabel(imagemCompartilharImagem);

    ImageIcon imagemCompartilharDoc = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/compartilharDoc.png"));
    JLabel mostraCompartilharDoc = new JLabel(imagemCompartilharDoc);

    public JPanel montaPainelChat() {

        btnCompartilharImagem = new JButton();
        btnCompartilharImagem.setBounds(821, 317, 40, 40);
        btnCompartilharImagem.setBorder(null);
        btnCompartilharImagem.setBackground(null);
        btnCompartilharImagem.setForeground(null);
        btnCompartilharImagem.setContentAreaFilled(false);
        btnCompartilharImagem.setIcon(imagemCompartilharImagem);
        btnCompartilharImagem.setVisible(false);

        btnCompartilharDoc = new JButton();
        btnCompartilharDoc.setBounds(821, 290, 40, 40);
        btnCompartilharDoc.setBorder(null);
        btnCompartilharDoc.setBackground(null);
        btnCompartilharDoc.setForeground(null);
        btnCompartilharDoc.setContentAreaFilled(false);
        btnCompartilharDoc.setIcon(imagemCompartilharDoc);
        btnCompartilharDoc.setVisible(false);

        JButton btnCompartilhar = new JButton();
        btnCompartilhar.setBounds(822, 345, 40, 40);
        btnCompartilhar.setBorder(null);
        btnCompartilhar.setBackground(null);
        btnCompartilhar.setForeground(null);
        btnCompartilhar.setContentAreaFilled(false);
        btnCompartilhar.setIcon(imagemCompartilhar);
        btnCompartilhar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCompartilharImagem.setVisible(true);
                btnCompartilharDoc.setVisible(true);
            }
        });

        JSeparator linhaSeparatorMenu = new JSeparator();
        linhaSeparatorMenu.setForeground(Color.WHITE);
        linhaSeparatorMenu.setBounds(220, 28, 1, 410);
        linhaSeparatorMenu.setOrientation(javax.swing.SwingConstants.VERTICAL);

        JScrollPane scroll = new JScrollPane();
        txaChat = new JTextArea();
        txaChat.setColumns(0);
        txaChat.setRows(0);
        txaChat.setBounds(260, 63, 600, 320);
        txaChat.setEditable(false);
        scroll.setViewportView(txaChat);

        JScrollPane scrollEnviar = new JScrollPane();
        txaEnviar = new JTextArea();
        txaEnviar.setColumns(0);
        txaEnviar.setRows(0);
        txaEnviar.setBounds(260, 390, 515, 35);
        txaEnviar.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                int tecla = KeyEvent.VK_ENTER;
                if (codigo == tecla) {                 
                       botaoEnviarActionPerformed();
                       System.out.println("algo");
                }
            }
        });
        scrollEnviar.setViewportView(txaEnviar);

        JButton btnEnviar = new JButton();
        btnEnviar = botoesPadrao.montaBtnAlteravel();
        btnEnviar.setText("Enviar");
        btnEnviar.setBounds(782, 390, 79, 35);
        btnEnviar.setBackground(new Color(0, 255, 127));
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 12));
        btnEnviar.setForeground(Color.WHITE);

        JLabel txtLblTitulo = new JLabel("NATURE");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        txtLblTitulo.setBounds(60, 20, 350, 32);

        JLabel txtLblMessageChat = new JLabel("MESSAGE CHAT");
        txtLblMessageChat.setForeground(Color.WHITE);
        txtLblMessageChat.setFont(new Font("Arial", Font.BOLD, 10));
        txtLblMessageChat.setBounds(72, 38, 350, 25);

        JTextField txfNome = new JTextField("Nome:");
        txfNome.setBorder(null);
        txfNome.setFont(new Font("Arial", Font.BOLD, 11));
        txfNome.setForeground(Color.WHITE);
        txfNome.setBackground(null);
        txfNome.setEditable(false);
        txfNome.setBounds(260, 37, 150, 25);

        JTextField txfStatusServidor = new JTextField("Status Servidor:");
        txfStatusServidor.setBorder(null);
        txfStatusServidor.setFont(new Font("Arial", Font.BOLD, 11));
        txfStatusServidor.setForeground(Color.WHITE);
        txfStatusServidor.setBackground(null);
        txfStatusServidor.setEditable(false);
        txfStatusServidor.setBounds(670, 37, 150, 25);

        JButton btnLogoff = new JButton();
        btnLogoff = botoesPadrao.montaBtnPadrao();
        btnLogoff.setText("Logoff");
        btnLogoff.setForeground(Color.WHITE);
        btnLogoff.setFont(new Font("Arial", Font.BOLD, 12));
        btnLogoff.setBounds(60, 420, 100, 25);
        btnLogoff.setContentAreaFilled(false);
        btnLogoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja mesmo Sair?") == 0) {
                    telaChat.dispose();
                    new TelaLogin();
                }
            }
        });

        JSeparator linhaSeparatorLogoff = new JSeparator();
        linhaSeparatorLogoff.setForeground(Color.WHITE);
        linhaSeparatorLogoff.setBounds(30, 420, 162, 1);

        painelChat.add(btnCompartilhar);
        painelChat.add(btnCompartilharImagem);
        painelChat.add(btnCompartilharDoc);
        painelChat.add(linhaSeparatorMenu);
        painelChat.add(txaChat);
        painelChat.add(scroll);
        painelChat.add(txaEnviar);
        painelChat.add(scrollEnviar);
        painelChat.add(btnEnviar);
        painelChat.add(txtLblTitulo);
        painelChat.add(txtLblMessageChat);
        painelChat.add(txfNome);
        painelChat.add(txfStatusServidor);
        painelChat.add(btnLogoff);
        painelChat.add(linhaSeparatorLogoff);

        return painelChat;
    }

    public void Chat() {

        try {
            s = new Socket("localhost", 5000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Thread();
    }

    private void Thread() {

        Thread tr = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String msgReceb;
                    isr = new InputStreamReader(s.getInputStream());
                    bff = new BufferedReader(isr);

                    while ((msgReceb = bff.readLine()) != null) {
                        txaChat.setText(txaChat.getText() + msgReceb + "\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        tr.start();
    }

    private void botaoEnviarActionPerformed() {
        try {
            String mensagem = " Walisson " + " Disse: ";
            PrintStream ps = new PrintStream(s.getOutputStream());
            mensagem += txaEnviar.getText();
            ps.println(mensagem);
            ps.flush();

            txaEnviar.setText("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
