package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    public static final int WINDOW_HEIGHT = 230;
    public static final int WINDOW_WIDTH = 350;

    JButton btnStart = new JButton("Start new game");

    JPanel settingsPanel;
    JRadioButtonMenuItem radioBtnGroup;

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setLocation(0,0);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        settingsPanel = new JPanel(new GridLayout(9,1));
        radioBtnGroup = new JRadioButtonMenuItem();

        settingsPanel.add(new JLabel("Выберите режим игры:"));
        settingsPanel.add(btnStart);
        add(settingsPanel);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3, 3);
                setVisible(false);
            }
        });

//        add(btnStart);
    }
}
