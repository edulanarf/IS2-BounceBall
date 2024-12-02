package ulpgc.es;

import java.util.Timer;
import java.util.TimerTask;

public class BallPresenter {
    private Ball ball;
    //private final BallDisplay ballDisplay;
    private final BallSimulator ballSimulator;

    public BallPresenter(Ball ball, BallSimulator ballSimulator) {
        this.ball = new Ball(ball.r(),ball.h(),ball.v(),ball.g(),ball.cr());
        //this.ballDisplay = ballDisplay;
        this.ballSimulator = ballSimulator;
    }

    public void execute(){
        new Timer().schedule(simulateTask(), 1, 1);
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
        ball = ballSimulator.simulate(this.ball);
        System.out.println(ball);
    }
}
