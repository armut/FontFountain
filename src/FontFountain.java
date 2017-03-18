import fenestra.Fenestra;
import fenestra.Palette;

import java.awt.*;

public class FontFountain extends Fenestra {
    public FontFountain(Color bgColor, Color captionColor, Color titleColor, String title, int width, int height) {
        super(bgColor, captionColor, titleColor, title, width, height);
        add(new FontSelector(bgColor, width/3, height), BorderLayout.WEST);
    }
}
