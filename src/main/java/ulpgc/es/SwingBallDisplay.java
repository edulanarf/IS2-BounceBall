package ulpgc.es;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingBallDisplay extends JPanel implements BallDisplay {
    private List<Paint> paints = new ArrayList<>();
    @Override
    public void drawCircle(int r, int y) {
        synchronized (paints) {
            paints.add(new Paint(y, r)); // Agregar de manera segura
        }
        repaint(); // Forzar la actualización del panel
    }

    @Override
    public void clear() {
        synchronized (paints) {
            paints.clear();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        synchronized (paints) {
            g.setColor(Color.BLACK);
            for (Paint paint : paints) {
                int centerX = (this.getWidth() / 2) - paint.r(); // Centrar en X
                int centerY = paint.y()+200; // 200 para que rebote mas o menos en el centro de la ventana (800+600)
                int diameter = paint.r() * 2; // Diámetro del círculo

                // Dibujar el contorno del círculo
                g.drawOval(centerX, centerY, diameter, diameter);
                g.drawLine(centerX-100, 300+paint.r(), centerX+100, 300+paint.r());
            }
        }
    }

    private record Paint(int y, int r) {
    }
}
