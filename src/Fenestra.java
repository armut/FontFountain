import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;

public class Fenestra extends JFrame {

    // Class attributes:
    private final static int WIDTH = 500;
    private final static int HEIGHT = 400;
    private final static String title = "Font Fountain";
    private int innerPosX, innerPosY;

    public Fenestra() {
        initUI();
        add(new FontSelector(400, HEIGHT), BorderLayout.LINE_START);
    }

    private void designFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setUndecorated(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                innerPosX = mouseEvent.getX();
                innerPosY = mouseEvent.getY();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                // do something...
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                setLocation(mouseEvent.getXOnScreen() - innerPosX,
                        mouseEvent.getYOnScreen() - innerPosY);
            }
        });
    }

    private void initUI() {
        designFrame();
    }

}
