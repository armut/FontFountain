package colorChooser;

import fountain.FontFountain;

/**
 * zamma on 30.03.2017.
 */
public class FontColorChooser extends ColorChooserBase {

    public FontColorChooser() {
        super();
    }

    protected void dye() {
        FontFountain.getPreviewPanel().getTextPane().setForeground(colorChooser.getColor());
    }
}
