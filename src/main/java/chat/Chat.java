package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    boolean isConnected = false;
    String login;
    JPanel northPanel, southPanel, loginPassPanel, ipPortPanel;
    JLabel loginLabel, passLabel, ipLabel, portLabel;
    JTextField loginTextField, ipTextField, portTextField, messageTextField;
    JPasswordField passTextField;
    JButton connectBtn, sendBtn;
    JTextArea textArea;


    Chat() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Chat");

        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);


//        Размещение элементов login / password
        loginLabel = new JLabel("Login:", SwingConstants.CENTER);
        loginTextField = new JTextField("User");
        passLabel = new JLabel("Password:", SwingConstants.CENTER);
        passTextField = new JPasswordField();

        loginPassPanel = new JPanel(new GridLayout(1, 4));
        loginPassPanel.add(loginLabel);
        loginPassPanel.add(loginTextField);
        loginPassPanel.add(passLabel);
        loginPassPanel.add(passTextField);

//        Размещение элементов ip / port
        ipLabel = new JLabel("IP address:", SwingConstants.CENTER);
        ipTextField = new JTextField("Введите IP адрес:");
        portLabel = new JLabel("port:", SwingConstants.CENTER);
        portTextField = new JTextField("Введите порт:");

        ipPortPanel = new JPanel(new GridLayout(1, 4));
        ipPortPanel.add(ipLabel);
        ipPortPanel.add(ipTextField);
        ipPortPanel.add(portLabel);
        ipPortPanel.add(portTextField);

//        Размещение кнопки connect
        connectBtn = new JButton("Connect");
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = loginTextField.getText();
                isConnected = true;
                messageTextField.setEnabled(true);
            }
        });


//        Компоновка верхней панели
        northPanel = new JPanel(new GridLayout(3, 1));
        northPanel.add(loginPassPanel);
        northPanel.add(ipPortPanel);
        northPanel.add(connectBtn);

//        Размещение текстового окна с историей сообщений
        textArea = new JTextArea();
        textArea.setEnabled(false);

//        Компонока южной панели
        messageTextField = new JTextField();
        messageTextField.setEnabled(false);
        messageTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    sendMessage();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        sendBtn = new JButton("Send");
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        southPanel = new JPanel(new GridLayout(1, 2));
        southPanel.add(messageTextField);
        southPanel.add(sendBtn);


//        Компоновка основного окна
        add(northPanel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    public static void main(String[] args) {
        new Chat();
    }

    private void sendMessage(){
        textArea.append(login + ": " + messageTextField.getText() + "\n");
        messageTextField.setText("");
    }
}

