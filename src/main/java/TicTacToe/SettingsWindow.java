package TicTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    JLabel sizeMapLbl;
    JLabel winLenghtLbl;

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setLocation(gameWindow.getX() + gameWindow.getWidth() / 2, gameWindow.getY() + gameWindow.getHeight() / 2);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        settingsPanel = new JPanel(new GridLayout(7, 1));
        radioBtnPanel = new JPanel(new GridLayout(1, 2));

        radioBtnGroup = new ButtonGroup();
        HumanVsHuman = new JRadioButton("Игрок vs Игрок");
        HumanVsAi = new JRadioButton("Игрок vs AI");
        radioBtnGroup.add(HumanVsHuman);
        radioBtnGroup.add(HumanVsAi);
        radioBtnPanel.add(HumanVsHuman);
        radioBtnPanel.add(HumanVsAi);

        sizeMapSlider = new JSlider(3, 10, 3);
        sizeMapSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sizeMapLbl.setText("Выберите размер поля: " + sizeMapSlider.getValue());

            }
        });

        winLenghtSlider = new JSlider(3, 10, 3);
        winLenghtSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLenghtLbl.setText("Выберите длину для победы: " + winLenghtSlider.getValue());
            }
        });

        settingsPanel.add(new JLabel("Выберите режим игры:", SwingConstants.CENTER));
        settingsPanel.add(radioBtnPanel);
        sizeMapLbl = new JLabel("Выберите размер поля: " + sizeMapSlider.getValue(), SwingConstants.CENTER);
        settingsPanel.add(sizeMapLbl);
        settingsPanel.add(sizeMapSlider);
        winLenghtLbl = new JLabel("Выберите длину для победы: " + winLenghtSlider.getValue(), SwingConstants.CENTER);
        settingsPanel.add(winLenghtLbl);
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
