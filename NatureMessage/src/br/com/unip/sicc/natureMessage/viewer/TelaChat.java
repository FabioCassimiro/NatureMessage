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

    private JButton btnImagem;
    private JButton btnDocumento;
    private JScrollPane scrollableTextArea;
    private JTextField txaEnviar;
    private JEditorPane txaChat;
    private String nomeUsuario;
    private JTextField txfNome;
    private JTextField txfStatusServidor;
    private final String actionName = "TECLA_ENTER";
    private JButton btnEnviar;
    private JButton btnCompartilhar;
    private JButton btnPerfil;
    private int porta;

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    PainelPadrao painelChat = new PainelPadrao();
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

    ImageIcon imagemCompartilhar = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/compartilhar.png"));
    JLabel mostraCompartilhar = new JLabel(imagemCompartilhar);
    ImageIcon imagemCompartilharImagem = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/compartilharImagem.png"));
    JLabel mostraCompartilharImagem = new JLabel(imagemCompartilharImagem);
    ImageIcon imagemCompartilharDoc = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/compartilharDoc.png"));
    JLabel mostraCompartilharDoc = new JLabel(imagemCompartilharDoc);
    ImageIcon imagemPerfil = new ImageIcon(getClass().getResource("/br/com/unip/sicc/natureMessage/image/perfil.png"));
    JLabel mostraPerfil = new JLabel(imagemPerfil);

    public JPanel montaPainelChat() {

        btnPerfil = componentes.montaBtnPadrao();
        btnPerfil.setBounds(60, 45, 100, 100);
        btnPerfil.setIcon(imagemPerfil);

        btnImagem = componentes.montaBtnPadrao();
        btnImagem.setBounds(-29, 180, 150, 40);
        btnImagem.setIcon(imagemCompartilharImagem);
        btnImagem.setText("Imagem");
        btnImagem.setForeground(Color.WHITE);
        btnImagem.setVisible(false);
        btnImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviaArquivo();
            }
        });

        btnDocumento = componentes.montaBtnPadrao();
        btnDocumento.setBounds(-20, 210, 150, 40);
        btnDocumento.setIcon(imagemCompartilharDoc);
        btnDocumento.setText("Documento");
        btnDocumento.setForeground(Color.WHITE);
        btnDocumento.setVisible(false);
        btnDocumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviaArquivo();
            }
        });

        btnCompartilhar = componentes.montaBtnPadrao();
        btnCompartilhar.setBounds(-16, 150, 150, 40);
        btnCompartilhar.setIcon(imagemCompartilhar);
        btnCompartilhar.setText("Compartilhar");
        btnCompartilhar.setForeground(Color.WHITE);
        btnCompartilhar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnImagem.setVisible(true);
                btnDocumento.setVisible(true);
            }
        });

        JSeparator linhaSeparatorMenu = new JSeparator();
        linhaSeparatorMenu.setForeground(Color.WHITE);
        linhaSeparatorMenu.setBounds(220, 28, 1, 410);
        linhaSeparatorMenu.setOrientation(javax.swing.SwingConstants.VERTICAL);

        scrollableTextArea = new JScrollPane(txaChat = new JEditorPane());
        txaChat.setEditable(false);
        scrollableTextArea.setBounds(260, 63, 600, 320);

        JScrollPane scrollEnviar = new JScrollPane(txaEnviar);
        txaEnviar = new JTextField();
        txaEnviar.setBounds(260, 390, 515, 35);

        
        btnEnviar = botoesPadrao.montaBtnAlteravel("Enviar");
        btnEnviar.setBounds(782, 390, 79, 35);
        btnEnviar.setBackground(new Color(0, 255, 127));
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 12));
        btnEnviar.setForeground(Color.WHITE);
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

        JLabel txtLblTitulo = new JLabel("NATURE");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        txtLblTitulo.setBounds(60, 20, 350, 32);

        JLabel txtLblMessageChat = new JLabel("MESSAGE CHAT");
        txtLblMessageChat.setForeground(Color.WHITE);
        txtLblMessageChat.setFont(new Font("Arial", Font.BOLD, 10));
        txtLblMessageChat.setBounds(72, 38, 350, 25);

        txfNome = new JTextField();
        txfNome.setBorder(null);
        txfNome.setFont(new Font("Arial", Font.BOLD, 11));
        txfNome.setForeground(Color.WHITE);
        txfNome.setBackground(null);
        txfNome.setEditable(false);
        txfNome.setBounds(50, 130, 150, 25);

        txfStatusServidor = new JTextField("Status Servidor:");
        txfStatusServidor.setBorder(null);
        txfStatusServidor.setFont(new Font("Arial", Font.BOLD, 11));
        txfStatusServidor.setForeground(Color.WHITE);
        txfStatusServidor.setBackground(null);
        txfStatusServidor.setEditable(false);
        txfStatusServidor.setBounds(260, 37, 150, 25);

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

        painelChat.add(btnPerfil);
        painelChat.add(btnCompartilhar);
        painelChat.add(btnImagem);
        painelChat.add(btnDocumento);
        painelChat.add(linhaSeparatorMenu);
        painelChat.add(scrollableTextArea);
        painelChat.add(scrollEnviar);
        painelChat.add(txaEnviar);
        painelChat.add(btnEnviar);
        painelChat.add(txtLblTitulo);
        painelChat.add(txtLblMessageChat);
        painelChat.add(txfNome);
        painelChat.add(txfStatusServidor);
        painelChat.add(btnLogoff);
        painelChat.add(linhaSeparatorLogoff);

        return painelChat;
    }

    public void Chat(int porta) {
        try {
            socketCliente = new Socket("localhost", porta);
            txfStatusServidor.setText("Status Servidor: Online");

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
                    txfNome.setText("Usuário: " + nomeUsuario);
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
            String mensagem = nomeUsuario;
            PrintStream ps = new PrintStream(socketCliente.getOutputStream());
            mensagem = nomeUsuario + " " + txaEnviar.getText() + " " + dataHora.get(Calendar.HOUR_OF_DAY) + ":" + dataHora.get(Calendar.MINUTE);
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
