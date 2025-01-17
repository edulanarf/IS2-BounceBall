package ulpgc.es.swing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingBallDisplay extends JPanel implements BallDisplay {
    private List<Paint> paints = new ArrayList<>();
    @Override
    public void drawCircle(int r, int y, int x) {
        synchronized (paints) {
            paints.add(new Paint(y, r, x)); // Agregar de manera segura
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
            for (Paint paint : paints) {
                int centerX = paint.x() - paint.r(); // Centrar en X
                int centerY = this.getHeight()/2 - paint.y() - paint.r();
                int diameter = paint.r() * 2;
                g.setColor(Color.RED);
                g.fillOval(centerX, centerY, diameter, diameter);
                g.drawOval(centerX, centerY, diameter, diameter);
                g.setColor(Color.BLACK);
                g.drawLine(centerX-500, this.getHeight()/2+paint.r(), centerX+500, this.getHeight()/2+paint.r());
            }
        }
    }

    private record Paint(int y, int r, int x) {
    }
}
