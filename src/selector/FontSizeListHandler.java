package selector;

import fountain.FontFountain;
import fountain.PreviewPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * zamma on 29.03.2017.
 */
public class FontSizeListHandler implements ListSelectionListener {
    private JList<String> sizeList;
    public FontSizeListHandler(JList<String> sizeList) {
        this.sizeList = sizeList;
    }
    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        FontFountain.currentFontSize = Integer.parseInt(sizeList.getSelectedValue());
        PreviewPanel.setPreviewPanelFont(
                new Font(FontFountain.currentFont.getName(), Font.PLAIN, FontFountain.currentFontSize)
        );
    }
}
