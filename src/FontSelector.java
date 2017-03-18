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
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(bgColor);
        appendFont(new Font("Courier", Font.PLAIN, 20));
        appendFont(new Font("Courier", Font.PLAIN, 20));

        add(initSearchfield(), BorderLayout.PAGE_START);
        add(initListBox(), BorderLayout.CENTER);

        jlFonts.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.isPopupTrigger()) {
                    JPopupMenu contextMenu = new JPopupMenu();
                    JMenuItem miApply = new JMenuItem("Apply");
                    JMenuItem miJmp = new JMenuItem("Jump to dir.");
                    miApply.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            System.out.println("Apply");
                        }
                    });
                    miJmp.addActionListener((new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            System.out.println("Jmp");
                        }
                    }));
                    contextMenu.add(miApply);
                    contextMenu.add(miJmp);
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void appendFont(Font font) {
        fontsList.add(font);
        listModel.addElement(font.getName());
    }

    private void removeFont(int index) {
        fontsList.remove(index);
        listModel.remove(index);
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
        JPanel jpnlFontList = new JPanel(new BorderLayout());
        jpnlFontList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Palette.darkGunmetal, 3), "Font list" ));
        jpnlFontList.setBackground(Palette.deepTaupe);
        JScrollPane jScrollPane = new JScrollPane(jlFonts);
        jpnlFontList.add(jScrollPane);

        return jpnlFontList;
    }
}
