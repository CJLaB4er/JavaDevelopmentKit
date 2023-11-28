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
    JPanel radioBtnPanel;
    ButtonGroup radioBtnGroup;
    JRadioButton HumanVsHuman;
    JRadioButton HumanVsAi;
    JSlider sizeMapSlider;
    JSlider winLenghtSlider;

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setLocation(0, 0);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        settingsPanel = new JPanel(new GridLayout(8, 1));
        radioBtnPanel = new JPanel(new GridLayout(1, 2));

        radioBtnGroup = new ButtonGroup();
        HumanVsHuman = new JRadioButton("Игрок vs Игрок");
        HumanVsAi = new JRadioButton("Игрок vs AI");
        radioBtnGroup.add(HumanVsHuman);
        radioBtnGroup.add(HumanVsAi);
        radioBtnPanel.add(HumanVsHuman);
        radioBtnPanel.add(HumanVsAi);

        sizeMapSlider = new JSlider(3, 10);
        winLenghtSlider = new JSlider(3, 10);

        settingsPanel.add(new JLabel("Выберите режим игры:", SwingConstants.CENTER));
        settingsPanel.add(radioBtnPanel);
        settingsPanel.add(new JLabel("Выберите размер поля:", SwingConstants.CENTER));
        settingsPanel.add(sizeMapSlider);
        settingsPanel.add(new JLabel("Выберите длину для победы:", SwingConstants.CENTER));
        settingsPanel.add(new JLabel("Установленная длина: ", SwingConstants.CENTER));
        settingsPanel.add(winLenghtSlider);
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
