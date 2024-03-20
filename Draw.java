import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame {
    private static final int DELAY = 100;//延迟

    public Draw() {
        setTitle("Draw");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int x = 300;
        int y = 600;
        int size = 300;
        int levels = 6;
        drawShape(g, x, y, size, levels);
    }

    public void drawShape(Graphics g, int x, int y, int size, int levels) {
        if (levels == 0) {
            return;
        }

        g.setColor(Color.BLACK);
        g.drawLine(x, y, x + size, y); // 绘制底边

        int height = (int) (size * Math.sqrt(3) / 2);
        int midX = x + size / 2;
        int midY = y - height;

        g.drawLine(x, y, midX, midY); // 绘制左斜边
        g.drawLine(x + size, y, midX, midY); // 绘制右斜边
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
        drawShape(g, x, y, size / 2, levels - 1); // 绘制左下角子图像
        drawShape(g, x + size / 2, y, size / 2, levels - 1); // 绘制右下角子图像
        drawShape(g, x + size / 4, y - height / 2, size / 2, levels - 1); // 绘制顶部子图像

    }
}