package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.model.Arquivo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TelaChat extends JFrame {

    private Socket socketCliente;
    private BufferedReader bufferedReader;
    private InputStreamReader inputStreamReader;
    private Calendar dataHora = Calendar.getInstance();
    private Arquivo arquivo;
    private FileInputStream fileInputStream;
    Componentes componentes = new Componentes();

    private JTextField txaEnviar;
    private JEditorPane txaChat;
    private JTextField txfNome;
    private JTextField txfStatusServidor;
    private final String actionName = "TECLA_ENTER";
    private int porta;
    private JLabel lblStatus;


    PainelPadrao pnlChat = new PainelPadrao();
    Componentes botoesPadrao = new Componentes();

    JFrame telaChat = new JFrame();

    public TelaChat(int portaServidor) {
        telaChat.add(montaPainelChat());
        telaChat.setSize(900, 500);
        telaChat.setLocationRelativeTo(null);
        telaChat.setUndecorated(true);
        telaChat.setVisible(true);
        botoesPadrao.setIcon(telaChat);
        Chat(portaServidor);
    }

    public JPanel montaPainelChat() {

        JButton btnPerfil = Componentes.montaBtnPadrao("");
        btnPerfil.setBounds(60, 45, 100, 100);
        btnPerfil.setIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/perfil.png"));

        JButton  btnImagem = Componentes.montaBtnPadrao("Imagem");
        btnImagem.setBounds(-29, 180, 150, 40);
        btnImagem.setIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/compartilharImagem.png"));
        btnImagem.setVisible(false);
        btnImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviaArquivo();
            }
        });

        JButton btnDocumento = Componentes.montaBtnPadrao("Documento");
        btnDocumento.setBounds(-20, 210, 150, 40);
        btnDocumento.setIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/compartilharDoc.png"));
        btnDocumento.setVisible(false);
        btnDocumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviaArquivo();
            }
        });

        JButton btnCompartilhar = Componentes.montaBtnPadrao("Compatilhar");
        btnCompartilhar.setBounds(-16, 150, 150, 40);
        btnCompartilhar.setIcon(componentes.image("/br/com/unip/sicc/natureMessage/image/compartilhar.png"));
        btnCompartilhar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnImagem.setVisible(true);
                btnDocumento.setVisible(true);
            }
        });
        
        JButton btnEnviar = botoesPadrao.montaBtnAlteravel("Enviar");
        btnEnviar.setBounds(782, 390, 79, 35);
        btnEnviar.setBackground(new Color(0, 255, 127));
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoEnviarActionPerformed();
            }
        });
        Action actionTecla = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //simula o click no botão
                btnEnviar.doClick();
            }
        };
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        InputMap inputMap = btnEnviar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, actionName);
        ActionMap actionMap = btnEnviar.getActionMap();
        actionMap.put(actionName, actionTecla);
        
        JButton btnLogoff = Componentes.montaBtnPadrao("Logoff");
        btnLogoff.setFont(new Font("Arial", Font.BOLD, 12));
        btnLogoff.setBounds(60, 420, 100, 25);
        btnLogoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja mesmo Sair?") == 0) {
                    telaChat.dispose();
                    new TelaLogin();
                }
            }
        });

        pnlChat.add(Componentes.linhaSeparadora(30, 420, 162, 1));
        JSeparator linhaSeparatorMenu = Componentes.linhaSeparadora(220, 28, 1, 410);
        linhaSeparatorMenu.setOrientation(javax.swing.SwingConstants.VERTICAL);
        
        JScrollPane barraChat = new JScrollPane(txaChat = new JEditorPane());
        txaChat.setEditable(false);
        barraChat.setBounds(260, 63, 600, 320);

        JScrollPane scrollEnviar = new JScrollPane(txaEnviar);
        txaEnviar = new JTextField();
        txaEnviar.setBounds(260, 390, 515, 35);
        
        pnlChat.add(Componentes.lblTexto("NATURE", 25, Color.WHITE, 60, 20, 350, 32));    
        pnlChat.add(Componentes.lblTexto("MESSAGE CHAT", 10, Color.WHITE, 72, 38, 350, 25));
        pnlChat.add(Componentes.lblTexto("Usuário: "+TelaLogin.nomeUsuario, 11, Color.WHITE, 50, 130, 150, 25));
        lblStatus = Componentes.lblTexto("" +TelaLogin.nomeUsuario, 11, Color.WHITE, 260, 37, 150, 25);

        pnlChat.add(btnPerfil);
        pnlChat.add(btnCompartilhar);
        pnlChat.add(btnImagem);
        pnlChat.add(btnDocumento);
        pnlChat.add(linhaSeparatorMenu);
        pnlChat.add(barraChat);
        pnlChat.add(scrollEnviar);
        pnlChat.add(txaEnviar);
        pnlChat.add(btnEnviar);
        pnlChat.add(btnLogoff);
        pnlChat.add(lblStatus);

        return pnlChat;
    }

    public void Chat(int porta) {
        try {
            socketCliente = new Socket("localhost", porta);
            lblStatus.setText("Status Servidor: Online");

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("erro");
        }
        Thread();
    }

    private void Thread() {
        Thread tr = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String msgReceb;
                    inputStreamReader = new InputStreamReader(socketCliente.getInputStream());
                    bufferedReader = new BufferedReader(inputStreamReader);

                    while ((msgReceb = bufferedReader.readLine()) != null) {
                        if (txaChat.getText().equals("")) {
                            txaChat.setText(msgReceb);
                        } else {
                            txaChat.setText(txaChat.getText() + "\n" + msgReceb);
                        }
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
            String mensagem = TelaLogin.nomeUsuario;
            PrintStream ps = new PrintStream(socketCliente.getOutputStream());
            mensagem = TelaLogin.nomeUsuario + " " + txaEnviar.getText() + " " + dataHora.get(Calendar.HOUR_OF_DAY) + ":" + dataHora.get(Calendar.MINUTE);
            ps.println(mensagem);
            ps.flush();
            txaEnviar.setText(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviaArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        Componentes componentes = new Componentes();
        fileChooser.showOpenDialog(null);
        fileChooser.setDialogTitle("Enviar");

        
        if (fileChooser.getSelectedFile() != null) {
            File arquivoEnviar = fileChooser.getSelectedFile();
            byte[] conteudo = new byte[(int) arquivoEnviar.length()];
            long tamanho = arquivoEnviar.length() / 1024;

            try {
                fileInputStream = new FileInputStream(arquivoEnviar);
                fileInputStream.read(conteudo);
                fileInputStream.close();
                componentes.montaAvisoMensagem("Arquivo " + arquivoEnviar.getName() + " enviado!", "SUCESSO");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            arquivo = new Arquivo(arquivoEnviar.getName(), conteudo, tamanho);
        }

    }
}
