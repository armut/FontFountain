import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * zamma on 30.03.2017.
 */
public class ColorChooserHandler implements ChangeListener {
    ColorChooserBase colorChooser;

    public ColorChooserHandler(ColorChooserBase colorChooser) {
        this.colorChooser = colorChooser;
    }
    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        colorChooser.dye();
    }
}
