package fountain;

import main.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * zamma on 16.04.2017.
 */
public class StatusPanel extends JPanel implements Observer {
    private JLabel jlblStatus;

    public StatusPanel() {
        setLayout(new BorderLayout());
        jlblStatus = new JLabel();
        jlblStatus.setText(FontFountain.currentFont.getName() + ", " + String.valueOf(FontFountain.currentFontSize));
        add(jlblStatus, BorderLayout.LINE_START);
    }

    @Override
    public void update(Font font) {
        jlblStatus.setText(font.getName() + ", " + String.valueOf(FontFountain.currentFontSize));
    }

    @Override
    public void update(int size) {
        jlblStatus.setText(FontFountain.currentFont.getName() + ", " + String.valueOf(size));
    }
}
