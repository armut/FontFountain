import fenestra.Palette;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FontSelector extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<String> jlFonts;
    private ArrayList<Font> fontsList;

    public FontSelector(Color bgColor, int width, int height) {
        listModel = new DefaultListModel<>();
        jlFonts = new JList<>(listModel);
        fontsList = new ArrayList<>();
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());
        setBackground(bgColor);

        // Placing a filler JPanel to distinguish menu and the other content.
        JPanel jpnlLoom = new JPanel(new BorderLayout());
        jpnlLoom.add(initSearchfield(), BorderLayout.PAGE_START);
        jpnlLoom.add(initListBox(), BorderLayout.CENTER);

        add(new FontSelectorMenu(), BorderLayout.PAGE_START);
        add(jpnlLoom, BorderLayout.CENTER);

        loadSystemFonts();
    }

    private void appendFont(Font font) {
        fontsList.add(font);
        listModel.addElement(font.getName());
    }

    private void removeFont(int index) {
        fontsList.remove(index);
        listModel.remove(index);
    }

    private void loadSystemFonts() {
        Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for(Font f : fonts)
            appendFont(f);
    }

    private void setCurrentFont(Font font) {
        FontFountain.currentFont = font;
    }

    private JPanel initSearchfield() {
        JPanel jpnlSearch = new JPanel(new BorderLayout());
        jpnlSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Palette.darkGunmetal, 3), "Search" ));
        jpnlSearch.setBackground(Palette.deepTaupe);
        JTextField jtfSearch = new JTextField("Search");
        jpnlSearch.add(jtfSearch);

        return jpnlSearch;
    }

    private JPanel initListBox() {
        ListBoxHandler handler = new ListBoxHandler(jlFonts, fontsList);
        JPanel jpnlFontList = new JPanel(new BorderLayout());
        jpnlFontList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Palette.darkGunmetal, 3), "Font list" ));
        jpnlFontList.setBackground(Palette.deepTaupe);
        jlFonts.setSelectedIndex(0);
        JScrollPane jScrollPane = new JScrollPane(jlFonts);
        jpnlFontList.add(jScrollPane);

        // Adding JList a right-click menu:
        jlFonts.addMouseListener(handler);
        jlFonts.addListSelectionListener(handler);

        return jpnlFontList;
    }
}
