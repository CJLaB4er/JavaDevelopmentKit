package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerStartStop extends JFrame implements Listener {
    JButton startServerBtn = new JButton("Start server");
    JButton stopServerBtn = new JButton("Stop server");
    JPanel startStopBtnPanel;
    JLabel logLabel;
    ListenerBtn btnListener;

    ServerStartStop() {
        btnListener = new Server(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setSize(400, 200);

        setTitle("Управление сервером");
        setResizable(false);

        startStopBtnPanel = new JPanel(new GridLayout(1, 2));
        startStopBtnPanel.add(startServerBtn);
        startStopBtnPanel.add(stopServerBtn);
        add(startStopBtnPanel, BorderLayout.CENTER);

        logLabel = new JLabel("Server down", SwingConstants.CENTER);
        add(logLabel, BorderLayout.SOUTH);

        setVisible(true);

        startServerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {btnListener.btnListen(true);
            }
        });
        stopServerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnListener.btnListen(false);
            }
        });
    }

    public static void main(String[] args) {
        new ServerStartStop();
    }

    @Override
    public void messageRes(String text) {
        logLabel.setText(text);
    }
}
