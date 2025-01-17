package ulpgc.es;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(20, 300.0, 0.0, -9.81, 0.5);
        MainFrame frame = new MainFrame();
        new BallPresenter(ball,new BallSimulator(0.3), frame.getBallDisplay()).execute();
        frame.setVisible(true);
    }
}
