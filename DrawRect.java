import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class DrawRect extends JPanel {

    public static final int HEIGHT = 900;
    public static final int WIDTH = 30;
    public static final Color RECT_COLOR = new Color(175,239,209);

    ArrayList<Integer> arr;

    public DrawRect(ArrayList<Integer> heights) {
        arr = heights;
    }

    public void setArr(ArrayList<Integer> newArr) {
        arr = newArr;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);
        graphics.setColor(RECT_COLOR);
        for (int i = 0, x = 10; x <= 1580; x += WIDTH + 4, i++) {
            int y = arr.get(i);
            graphics.fillRect(x, y, WIDTH, HEIGHT);
        }
    }
}

