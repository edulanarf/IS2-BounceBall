package ulpgc.es;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(1.0, 10.0, 0.0, -9.81, 0.8);
        new BallPresenter(ball,new BallSimulator(0.001)).execute();
    }
}
