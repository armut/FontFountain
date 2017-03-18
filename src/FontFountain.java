import fenestra.Fenestra;
import fenestra.Palette;

import javax.swing.*;
import java.awt.*;

public class FontFountain extends Fenestra {
    public FontFountain(Color bgColor, Color captionColor, Color titleColor, String title, int width, int height) {
        super(bgColor, captionColor, titleColor, title, width, height);
        add(new FontSelector(bgColor, width/3, height), BorderLayout.LINE_START);

        JPanel jpnlLoom = new JPanel(new BorderLayout());
        jpnlLoom.setBackground(bgColor);
        jpnlLoom.add(new MenuPanel(), BorderLayout.PAGE_START);
        add(jpnlLoom, BorderLayout.CENTER);
    }
}
