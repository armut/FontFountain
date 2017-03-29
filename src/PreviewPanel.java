import fenestra.Palette;

import javax.swing.*;
import java.awt.*;

public class PreviewPanel extends JPanel {
    static JTextPane textPane;
    private JScrollPane scrollPane;
    private String quote = "Don Quixote";

    public PreviewPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Palette.deepTaupe);

        textPane = new JTextPane();
        textPane.setBackground(Palette.mistyRose);
        textPane.setFont(FontFountain.currentFont);

        scrollPane = new JScrollPane(textPane);
        add(scrollPane);
    }
}
