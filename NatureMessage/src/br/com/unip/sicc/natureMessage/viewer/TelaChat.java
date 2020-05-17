package br.com.unip.sicc.natureMessage.viewer;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.control.ConfigChat;
import br.com.unip.sicc.natureMessage.model.Arquivo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

public class TelaChat extends JFrame {

    private Arquivo arquivo;
    Componentes componentes = new Componentes();
    private JTextField txaEnviar;
    private JEditorPane txaChat;
    private final String actionName = "TECLA_ENTER";
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
        botoesPadrao.montaIconeFrame(telaChat);
        ConfigChat.Chat(txaChat, portaServidor);
    }

    public JPanel montaPainelChat() {

        JButton btnPerfil = Componentes.montaBotaoPadrao("");
        btnPerfil.setBounds(60, 45, 100, 100);
        btnPerfil.setIcon(componentes.buscaImagem("perfil.png"));

        JButton btnEnviar = botoesPadrao.montaBotaoAlteravel("Enviar");
        btnEnviar.setBounds(782, 390, 79, 35);
        btnEnviar.setBackground(new Color(0, 255, 127));
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigChat.botaoEnviarActionPerformed(txaEnviar);
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

        JButton btnLogoff = Componentes.montaBotaoPadrao("Logoff");
        btnLogoff.setFont(new Font("Arial", Font.BOLD, 12));
        btnLogoff.setBounds(60, 420, 100, 25);
        btnLogoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Logoff", JOptionPane.YES_OPTION) == 0) {
                    AcoesBancoDeDados.atualizaUltimoLogin(AcoesBancoDeDados.comandoUpdate("VISTO", "Ultimo acesso: " + Componentes.dataHoraAtual(), " NOLOGIN = " + "'" + AcoesBancoDeDados.resultNoLogin + "'", "TB_USUARIO"));
                    telaChat.dispose();
                    new TelaLogin();
                }
            }
        });

        JButton desconectServidor = botoesPadrao.montaBotaoAlteravel("Desconectar do servidor");
        desconectServidor.setBounds(34, 385, 150, 35);
        desconectServidor.setFont(new Font("Arial", Font.BOLD, 12));
        desconectServidor.setBackground(null);
        desconectServidor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaChat.dispose();
                new TelaServidor();
            }
        });

        pnlChat.add(Componentes.montaSeparadora(30, 420, 162, 1));
        JSeparator linhaSeparatorMenu = Componentes.montaSeparadora(220, 28, 1, 410);
        linhaSeparatorMenu.setOrientation(javax.swing.SwingConstants.VERTICAL);

        JScrollPane barraChat = new JScrollPane(txaChat = new JEditorPane());
        txaChat.setEditable(false);
        txaChat.setText(ConfigChat.dadosChat());
        txaChat.setForeground(new Color(138, 43, 226));
        txaChat.setFont(new Font("Arial", Font.PLAIN, 15));
        barraChat.setBounds(260, 63, 600, 320);
        barraChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollPane scrollEnviar = new JScrollPane(txaEnviar);
        txaEnviar = new JTextField();
        txaEnviar.setBounds(260, 390, 515, 35);

        pnlChat.add(Componentes.montaTexto("NATURE", 25, Color.WHITE, 60, 20, 350, 32));
        pnlChat.add(Componentes.montaTexto("- MESSAGE CHAT -", 10, Color.WHITE, 65, 38, 350, 25));
        pnlChat.add(Componentes.montaTexto("Usuário: " + TelaLogin.nomeUsuario, 11, Color.WHITE, 50, 130, 150, 25));
        lblStatus = Componentes.montaTexto("Conectado a: " + AcoesBancoDeDados.resultNoServidor, 11, Color.WHITE, 260, 37, 150, 25);

        pnlChat.add(Componentes.montaTexto("Nome: " + AcoesBancoDeDados.noPessoa + " " + AcoesBancoDeDados.noSobrenome, 12, Color.WHITE, 16, 165, 200, 35));
        pnlChat.add(Componentes.montaTexto("Empresa: " + AcoesBancoDeDados.noEmpresa, 12, Color.WHITE, 16, 185, 200, 35));
        pnlChat.add(Componentes.montaTexto("Cargo: " + AcoesBancoDeDados.noCargo, 12, Color.WHITE, 16, 205, 200, 35));

        pnlChat.add(btnPerfil);
        pnlChat.add(desconectServidor);
        pnlChat.add(linhaSeparatorMenu);
        pnlChat.add(barraChat);
        pnlChat.add(scrollEnviar);
        pnlChat.add(txaEnviar);
        pnlChat.add(btnEnviar);
        pnlChat.add(btnLogoff);
        pnlChat.add(lblStatus);

        return pnlChat;
    }

}
