import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenestra extends JFrame {

    private int innerPosX, innerPosY;
    private Palette palette = Palette.getPalette();

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
    }

}
