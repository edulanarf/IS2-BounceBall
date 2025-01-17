package ulpgc.es;

public class BallSimulator {
    private final double dt;

    public BallSimulator(double dt) {
        this.dt = dt;
    }
    public Ball simulate(Ball ball){
        return willBounce(ball) ?
                new Ball(ball.r(), newHeightAfterBounce(ball), newVelocityAfterBounce(ball), ball.g(), ball.cr()) : //Si rebota
                new Ball(ball.r(), newHeightOf(ball), newVelocityOf(ball), ball.g(), ball.cr());              //Si no rebota
    }

    private double newHeightAfterBounce(Ball ball) {
        // Calculamos la altura después del rebote, usando la nueva velocidad
        double velocityAfterBounce = newVelocityAfterBounce(ball);
        return -velocityAfterBounce * timeToBounce(ball) + ball.h();
    }

    private double newVelocityAfterBounce(Ball ball) {
        // La nueva velocidad después del rebote
        return -ball.cr() * ball.v();
    }

    private double timeToBounce(Ball ball) {
        // Calculamos el tiempo para llegar al suelo desde la altura actual
        return -ball.h() / ball.v(); // Tiempo de caída hasta el suelo
    }

    private double newVelocityOf(Ball ball) {
        // Calculamos la nueva velocidad después de un intervalo de tiempo (dt) considerando la gravedad
        return ball.v() + ball.g() * dt;
    }

    private double newHeightOf(Ball ball) {
        // Calculamos la nueva altura utilizando la fórmula estándar de cinemática
        double newHeightBall = ball.h() + ball.v() * dt + 0.5 * ball.g() * dt * dt;
        return newHeightBall;

    }

    private boolean willBounce(Ball ball) {
        // Verificamos si la pelota ha tocado el suelo
        return ball.h() <= 0 && ball.v() <= 0;
        }
    }