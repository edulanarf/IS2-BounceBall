package ulpgc.es;

public class BallSimulator {
    private final double dt;

    public BallSimulator(double dt) {
        this.dt = dt;
    }
    public Ball simulate(Ball ball){
        return willBounds(ball) ?
                new Ball(ball.r(), newHighAfterBounceOf(ball) , newVelocityOf(ball), ball.g(), ball.cr()) : //Si rebota
                new Ball(ball.r(), newHighOf(ball), newVelocityOf(ball), ball.g(), ball.cr());              //Si no rebota
    }

    private double newHighAfterBounceOf(Ball ball) {
        return newVelocityBounce(ball) * (dt-timeOfBounced(ball));
    }

    private double newVelocityBounce(Ball ball) {
        return -ball.cr()*(ball.v()+ ball.g()*timeOfBounced(ball));
    }

    private double timeOfBounced(Ball ball) {
        return -ball.v() / ball.g(); // ms/ms^2 = s
    }

    private double newVelocityOf(Ball ball) {
        return ball.v()+ball.g()*dt;
    }


    private double newHighOf(Ball ball) {
        return ball.h()+ball.v()+dt;
    }
    private boolean willBounds(Ball ball) {
        return dt > -ball.h()/ball.v() && ball.v() < 0;
    }
}
