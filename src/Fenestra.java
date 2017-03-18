import javax.swing.*;
import java.awt.*;

public class Fenestra extends JFrame {
    public Fenestra(Color bgColor, Color captionColor, String title, int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        setSize(width, height);
        setResizable(true);
        setUndecorated(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);
        add(new Caption(this, captionColor, title), BorderLayout.PAGE_START);
        setVisible(true);
    }
}
