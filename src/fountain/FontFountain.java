package fountain;

import fenestra.Fenestra;
import menu.MainMenu;

import javax.swing.*;
import java.awt.*;

public class FontFountain extends Fenestra {
    public static Font currentFont;
    public static int currentFontSize;
    private static PreviewPanel previewPanel;

    public FontFountain(Color bgColor, Color captionColor, Color titleColor, String title, int width, int height) {
        super(bgColor, captionColor, titleColor, title, width, height);

        previewPanel = new PreviewPanel();

        // Loom panel is the main workspace of the window.
        JPanel jpnlLoom = new JPanel(new BorderLayout());
        jpnlLoom.setBackground(bgColor);
        jpnlLoom.add(new MainMenu(), BorderLayout.PAGE_START);

        jpnlLoom.add(previewPanel, BorderLayout.CENTER);

        add(jpnlLoom, BorderLayout.CENTER);
        //TODO: Status bar.

        setDefaultFont();
    }

    private void setDefaultFont() {
        //TODO: Set default font to the last font used in the last session of this program.
        currentFontSize = 72;
        currentFont = new Font("Courier", Font.PLAIN, currentFontSize);
        previewPanel.setFont(currentFont);
    }

    public void setCurrentFont(Font font) {
        currentFont = font;
        previewPanel.setFont(currentFont);
    }

    public static PreviewPanel getPreviewPanel() {
        return previewPanel;
    }

}
