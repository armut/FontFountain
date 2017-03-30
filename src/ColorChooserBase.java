/**
 * zamma on 30.03.2017.
 */

import fenestra.Palette;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;

public abstract class ColorChooserBase extends JPanel {
    protected JColorChooser colorChooser;

    public ColorChooserBase() {
        colorChooser = new JColorChooser(Palette.paynesGrey);
        ColorChooserHandler colorChooserHandler = new ColorChooserHandler(this);
        ColorSelectionModel model = colorChooser.getSelectionModel();
        model.addChangeListener(colorChooserHandler);

        // Remove unnecessary panels:
        colorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
        for(AbstractColorChooserPanel p : panels) {
            if(!p.getDisplayName().equals("RGB") && !p.getDisplayName().equals("CMYK"))
                colorChooser.removeChooserPanel(p);
        }
        add(colorChooser);
    }

    protected abstract void dye();
}
