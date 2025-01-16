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

    public void paint(Graphics g){
        for(Paint paint: paints){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            // Dibujar el contorno del círculo
            g.drawOval(200, paint.y, paint.r * 2, paint.y);
        }
    }

    private record Paint(int y, int r) {
    }
}
