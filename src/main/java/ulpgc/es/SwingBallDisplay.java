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
        synchronized (paints) {
            for (Paint paint : paints) {
                int centerX = (this.getWidth() / 2) - paint.r(); // Centrar en X
                int centerY = paint.y(); // Coordenada Y del círculo
                int diameter = paint.r() * 2; // Diámetro del círculo

                // Dibujar el contorno del círculo
                g.drawOval(centerX, centerY, diameter, diameter);
            }
        }
    }

    private record Paint(int y, int r) {
    }
}
