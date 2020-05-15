package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.viewer.Componentes;
import br.com.unip.sicc.natureMessage.viewer.TelaLogin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ConfigChat {

    static Socket socketCliente;

    public static void Chat(JEditorPane txaChat, int porta) {
        try {
            socketCliente = new Socket(AcoesBancoDeDados.resulIpServidor, porta);
            Thread(txaChat, socketCliente);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("erro");
        }

    }

    private static void Thread(JEditorPane txaChat, Socket socketCliente) {

        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String msgReceb;
                    InputStreamReader inputStreamReader = new InputStreamReader(socketCliente.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    while ((msgReceb = bufferedReader.readLine()) != null) {
                        if (txaChat.getText().equals("")) {
                            txaChat.setText(msgReceb);
                        } else {
                            String msg = txaChat.getText() + "\n\n" + msgReceb;
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    txaChat.setText(msg);
                                }
                            });
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        tr.start();
    }

    public static void botaoEnviarActionPerformed(JTextField txaEnviar) {
        Calendar dataHora = Calendar.getInstance();
        if (!txaEnviar.getText().equals("")) {
            try {
                String mensagem = TelaLogin.nomeUsuario;
                PrintStream ps = new PrintStream(socketCliente.getOutputStream());
                mensagem = "[" + TelaLogin.nomeUsuario + "]" + "----" + txaEnviar.getText() + "----" + Componentes.dataHoraAtual() + "----" + AcoesBancoDeDados.resultNoServidor;
                ps.println(mensagem);
                ps.flush();
                txaEnviar.setText(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String carregaMensagem() {
        String[] campos = {"NOSERVIDOR"};
        String[] dados = {AcoesBancoDeDados.resultNoServidor};
        AcoesBancoDeDados.carregaMensagem(AcoesBancoDeDados.comandoSelect(campos, dados, "TB_MENSAGEM"));
        
        return AcoesBancoDeDados.mensagemCompleta;
    }
}
