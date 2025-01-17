package ulpgc.es.model;

import ulpgc.es.swing.BallDisplay;

import java.util.Timer;
import java.util.TimerTask;

public class BallPresenter {
    private Ball ball;
    private final BallDisplay ballDisplay;
    private final BallSimulator ballSimulator;

    public BallPresenter(Ball ball, BallSimulator ballSimulator,BallDisplay ballDisplay) {
        this.ball = new Ball(ball.r(),ball.h(),ball.v(),ball.g(),ball.cr(), ball.x());
        this.ballDisplay = ballDisplay;
        this.ballSimulator = ballSimulator;
    }

    public void execute(){
        new Timer().schedule(simulateTask(), 10, 10);
    }

    private TimerTask simulateTask() {
        return new TimerTask() {
            @Override
            public void run() {
                simulate();
            }
        };
    }



    public void simulate(){
        this.ballDisplay.clear();
        ball = ballSimulator.simulate(this.ball);
        this.ballDisplay.drawCircle((int) ball.r(),(int) ball.h(), (int) ball.x());
    }
}
