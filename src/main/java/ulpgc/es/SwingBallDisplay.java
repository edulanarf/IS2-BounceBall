package ulpgc.es;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingBallDisplay extends JPanel implements BallDisplay {
    private List<Paint> paints = new ArrayList<>();
    @Override
    public void drawCircle(int r, int y) {
        paints.add(new Paint(y,r));
        repaint();
    }

    @Override
    public void clear() {
        paints.clear();
        repaint();
    }

    @Override
    public void paint(Graphics g){
        for(Paint paint: paints){
            int centerX = (this.getWidth() / 2) - paint.r(); // Centrar en X
            int centerY = paint.y(); // Coordenada Y del círculo
            int diameter = paint.r() * 2; // Diámetro del círculo

            // Dibujar el contorno del círculo
            g.drawOval(centerX, centerY, diameter, diameter);
        }
    }

    private record Paint(int y, int r) {
    }
}
