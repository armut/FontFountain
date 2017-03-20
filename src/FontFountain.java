import fenestra.Fenestra;
import fenestra.Floris;

import javax.swing.*;
import java.awt.*;

public class FontFountain extends Fenestra {
    static Floris fontSelectorDialog;

    public FontFountain(Color bgColor, Color captionColor, Color titleColor, String title, int width, int height) {
        super(bgColor, captionColor, titleColor, title, width, height);
        fontSelectorDialog = new Floris(this, bgColor, captionColor, titleColor, "Font Selector", 200, 450);
        fontSelectorDialog.add(new FontSelector(bgColor, width, height));

        // Loom panel is the main workspace of the window.
        JPanel jpnlLoom = new JPanel(new BorderLayout());
        jpnlLoom.setBackground(bgColor);
        jpnlLoom.add(new MenuPanel(), BorderLayout.PAGE_START);

        add(jpnlLoom, BorderLayout.CENTER);
    }

}
