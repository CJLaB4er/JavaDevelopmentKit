package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerStartStop extends JFrame {
    JButton startServerBtn = new JButton("Start server");
    JButton stopServerBtn = new JButton("Stop server");
    boolean serverWorking = false;
    JPanel startStopBtnPanel;

    ServerStartStop() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setSize(800, 400);

        setTitle("Управление сервером");
        setResizable(false);

        startStopBtnPanel = new JPanel(new GridLayout(1, 2));
        startStopBtnPanel.add(startServerBtn);
        startStopBtnPanel.add(stopServerBtn);
        add(startStopBtnPanel);

        startServerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!serverWorking) {
                    serverWorking = true;
                    System.out.println("Сервер запущен");
                }else System.out.println("Сервер уже запущен");
            }
        });

        stopServerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWorking) {
                    serverWorking = false;
                    System.out.println("Сервер остановлен");
                } else System.out.println("Сервер уже был остановлен ранее");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerStartStop();
    }
}
