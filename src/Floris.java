import javax.swing.*;
import java.awt.*;

/**
 * zamma on 18.03.2017.
 */
public class Floris extends JDialog {
    public Floris(Color bgColor, Color captionColor, String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setResizable(true);
        setUndecorated(true);
        setLayout(new BorderLayout());
        getContentPane().setBackground(bgColor);
        add(new Caption(this, captionColor, title), BorderLayout.PAGE_START);
        setVisible(true);
    }
}
