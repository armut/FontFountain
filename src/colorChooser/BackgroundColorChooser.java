package colorChooser;

import fountain.FontFountain;

/**
 * zamma on 30.03.2017.
 */
public class BackgroundColorChooser extends ColorChooserBase {

    public BackgroundColorChooser() {
        super();
    }

    protected void dye() {
        FontFountain.getPreviewPanel().getTextPane().setBackground(colorChooser.getColor());
    }
}
