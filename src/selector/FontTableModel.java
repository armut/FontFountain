package selector;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * zamma on 19.05.2017.
 */
class FontTableModel extends DefaultTableModel {
    void addRow(String fontName, Font font) {
        Vector vector = new Vector(2);
        vector.addElement(fontName);
        vector.addElement(font);
        this.addRow(vector);
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
}
