package circles;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public static final int POS_X = 400;
    public static final int POS_Y = 200;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGT = 600;
    private final Interactable[] interactables = new Interactable[10];

    private MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGT);
        setTitle("Circles");
        for (int i = 0; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);

        }
    }

    public void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);

        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
