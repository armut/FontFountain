package selector;

import fountain.FontFountain;

import javax.swing.*;
import java.awt.*;

/**
 * zamma on 29.03.2017.
 */
public class FontSize extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<String> jlSizes;
    private FontSizeListHandler handler;
    private int[] sizes = {4, 6, 8, 9, 10, 11, 12, 13, 14, 16, 18, 20, 22, 24, 28, 32, 36, 40, 48, 56, 64, 72, 144};

    public FontSize(Color bgColor) {
        listModel = new DefaultListModel<>();
        jlSizes = new JList<>(listModel);
        handler = new FontSizeListHandler(jlSizes);

        setLayout(new BorderLayout());
        setBackground(bgColor);

        JPanel jpnlLoom = new JPanel();
        jpnlLoom.setLayout(new BoxLayout(jpnlLoom, BoxLayout.PAGE_AXIS));
        jpnlLoom.add(initList(sizes));
        //jpnlLoom.add(initCustomSizeField());

        add(jpnlLoom, BorderLayout.CENTER);
    }

    private JPanel initList(int[] sizes) {
        jlSizes.addListSelectionListener(handler);

        for(int s : sizes)
            listModel.addElement(String.valueOf(s));
        JPanel jpnlList = new JPanel();
        jpnlList.setBackground(this.getBackground());
        jpnlList.setBorder(BorderFactory.createLineBorder(this.getBackground(), 5));
        jpnlList.setLayout(new BoxLayout(jpnlList, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(jlSizes);
        jpnlList.add(scrollPane);
        return jpnlList;
    }

    private JPanel initCustomSizeField() {
        JPanel jpnlCustomSize = new JPanel();
        JLabel jlbl = new JLabel("Size:");
        JTextField jtf = new JTextField(4);
        jtf.setText(String.valueOf(FontFountain.currentFontSize));
        jpnlCustomSize.add(jlbl);
        jpnlCustomSize.add(jtf);
        return jpnlCustomSize;
    }

    public FontSizeListHandler getHandler() {
        return handler;
    }
}
