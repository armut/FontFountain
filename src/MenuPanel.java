import fenestra.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPanel extends JPanel implements ActionListener {
    private final Color MENU_FORECOLOR = Palette.middleRedPurple;
    private final Color MENU_BACKCOLOR = Palette.paynesGrey;
    private final Font MENU_FONT = new Font("Courier", Font.BOLD, 10);

    public MenuPanel() {
        setBackground(Palette.halayaUbe);
        setLayout(new BorderLayout());

        // One JMenuBar instance:
        JMenuBar jmbMenu = new JMenuBar();
        jmbMenu.setBackground(Palette.halayaUbe);
        jmbMenu.setBorderPainted(false);

        /* JMenuItem arrays for every JMenu */
        // File menu items:
        ArrayList<JMenuItem> fileMenuItems = new ArrayList<>();
        JMenuItem jmLoadFont = generateMenuItem("LOAD FONT");
        JMenuItem jmDump = generateMenuItem("DUMP FONT LIST");
        JMenuItem jmSettings = generateMenuItem("SETTINGS");
        fileMenuItems.add(jmLoadFont);
        fileMenuItems.add(jmDump);
        fileMenuItems.add(jmSettings);
        for(JMenuItem item : fileMenuItems)
                item.addActionListener(this);

        // View menu items:
        ArrayList<JMenuItem> viewMenuItems = new ArrayList<>();
        JMenuItem jmSelector = generateMenuItem("FONT SELECTOR");
        JMenuItem jmComparator = generateMenuItem("FONT COMPARATOR");
        JMenuItem jmComposer = generateMenuItem("COMPOSER");
        viewMenuItems.add(jmSelector);
        viewMenuItems.add(jmComparator);
        viewMenuItems.add(jmComposer);
        for(JMenuItem item : viewMenuItems)
            item.addActionListener(this);

        // Edit menu items:
        ArrayList<JMenuItem> editMenuItems = new ArrayList<>();
        JMenuItem jmSetBg = generateMenuItem("BACKGROUND COLOR");
        JMenuItem jmSetFg = generateMenuItem("FOREGROUND COLOR");
        JMenuItem jmSetSize = generateMenuItem("DISPLAY SIZE");
        editMenuItems.add(jmSetSize);
        editMenuItems.add(jmSetBg);
        editMenuItems.add(jmSetFg);
        for(JMenuItem item : editMenuItems)
            item.addActionListener(this);

        // JMenu instances:
        JMenu fileMenu = generateMenu("FILE", fileMenuItems);
        JMenu viewMenu = generateMenu("VIEW", viewMenuItems);
        JMenu editMenu = generateMenu("EDIT", editMenuItems);

        // Adding JMenus to JMenuBar:
        jmbMenu.add(fileMenu);
        jmbMenu.add(viewMenu);
        jmbMenu.add(editMenu);

        // Adding JMenuBar to the panel:
        add(jmbMenu, BorderLayout.LINE_START);
    }

    private JMenu generateMenu(String title, ArrayList<JMenuItem> menuItems) {
        JMenu menu = new JMenu(title);
        menu.setBorderPainted(false);
        menu.getPopupMenu().setBorder(null);
        menu.setFont(MENU_FONT);
        menu.setForeground(MENU_FORECOLOR);
        for(int i = 0; i < menuItems.size(); i++)
            menu.add(menuItems.get(i));
        return menu;
    }

    private JMenuItem generateMenuItem(String title) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setBorderPainted(false); // or create a line border.
        menuItem.setBackground(MENU_BACKCOLOR);
        menuItem.setFont(MENU_FONT);
        menuItem.setForeground(MENU_FORECOLOR);
        return menuItem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("FONT SELECTOR")) {
            if(FontFountain.fontSelectorDialog.isVisible()) {
                FontFountain.fontSelectorDialog.setVisible(false);
            } else {
                FontFountain.fontSelectorDialog.setVisible(true);
            }
        }
    }

}
