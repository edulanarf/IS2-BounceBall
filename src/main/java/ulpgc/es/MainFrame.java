package ulpgc.es;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BallDisplay ballDisplay;

    public MainFrame()  {
        this.setTitle("Bounce Ball");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createImageDisplay());
    }

    private Component createImageDisplay() {
        SwingBallDisplay display = new SwingBallDisplay();
        this.ballDisplay = display;
        return display;
    }

    public BallDisplay getBallDisplay() {
        return ballDisplay;
    }
}
