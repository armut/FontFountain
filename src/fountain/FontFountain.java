package fountain;

import fenestra.Fenestra;
import main.Observer;
import menu.MainMenu;

import javax.swing.*;
import java.awt.*;

public class FontFountain extends Fenestra implements Observer {
    public static Font currentFont;
    public static int currentFontSize;
    private static PreviewPanel previewPanel;
    private StatusPanel statusPanel;

    public FontFountain(Color bgColor, Color captionColor, Color titleColor, String title, int width, int height) {
        super(bgColor, captionColor, titleColor, title, width, height);

        // Initialize the default configuration.
        setDefaultFont();

        previewPanel = new PreviewPanel();
        previewPanel.setFont(currentFont);
        statusPanel = new StatusPanel();
        previewPanel.registerObserver(statusPanel);

        // Loom panel is the main workspace of the window.
        JPanel jpnlLoom = new JPanel(new BorderLayout());
        jpnlLoom.setBackground(bgColor);
        jpnlLoom.add(new MainMenu(), BorderLayout.PAGE_START);

        jpnlLoom.add(previewPanel, BorderLayout.CENTER);

        add(jpnlLoom, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void setDefaultFont() {
        currentFontSize = 36;
        currentFont = new Font("Serif", Font.PLAIN, currentFontSize);
    }

    public static PreviewPanel getPreviewPanel() {
        return previewPanel;
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    @Override
    public void update(Font font) {
        currentFont = font;
        PreviewPanel.setPreviewPanelFont(
                new Font(FontFountain.currentFont.getName(), Font.PLAIN, FontFountain.currentFontSize));
    }

    @Override
    public void update(int size) {
        currentFontSize = size;
        PreviewPanel.setPreviewPanelFont(
                new Font(FontFountain.currentFont.getName(), Font.PLAIN, FontFountain.currentFontSize));
    }
}
