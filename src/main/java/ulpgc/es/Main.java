package ulpgc.es;

import ulpgc.es.model.Ball;
import ulpgc.es.model.BallPresenter;
import ulpgc.es.model.BallSimulator;
import ulpgc.es.swing.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        Ball ballTierra = new Ball(20, 300.0, 0.0, -9.81, 0.8, 400);
        new BallPresenter(ballTierra,new BallSimulator(0.1), frame.getBallDisplay()).execute();
        frame.setVisible(true);
    }
}
