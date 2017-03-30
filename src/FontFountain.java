import fenestra.Fenestra;
import fenestra.Floris;

import javax.swing.*;
import java.awt.*;

public class FontFountain extends Fenestra {
    static Floris fontSelectorDialog;
    static Floris fontSizeDialog;
    static Floris fontColorChooserDialog;
    static Floris backgroundColorChooserDialog;
    static Font currentFont;
    static int currentFontSize;
    private static PreviewPanel previewPanel;

    public FontFountain(Color bgColor, Color captionColor, Color titleColor, String title, int width, int height) {
        super(bgColor, captionColor, titleColor, title, width, height);
        fontSelectorDialog = new Floris(this, bgColor, captionColor, titleColor, "Font Selector", 200, 450);
        fontSelectorDialog.add(new FontSelector(bgColor, width, height));

        fontSizeDialog = new Floris(this, bgColor, captionColor, titleColor, "Font Size", 125, 250);
        fontSizeDialog.add(new FontSize(bgColor));

        fontColorChooserDialog = new Floris(this, bgColor, captionColor,
                titleColor, "Font Color Chooser", 625, 275);
        fontColorChooserDialog.add(new FontColorChooser());

        backgroundColorChooserDialog = new Floris(this, bgColor, captionColor,
                titleColor, "Background Color Chooser", 635, 275);
        backgroundColorChooserDialog.add(new BackgroundColorChooser());

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
