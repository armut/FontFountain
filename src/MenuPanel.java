import fenestra.Palette;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        setBackground(Palette.halayaUbe);
        setLayout(new BorderLayout());

        // One JMenuBar instance:
        JMenuBar jmbMenu = new JMenuBar();
        jmbMenu.setBackground(Palette.halayaUbe);
        jmbMenu.setBorderPainted(false);

        // JMenuItem arrays for every JMenu:
        ArrayList<JMenuItem> fileMenuItems = new ArrayList<>();
        JMenuItem jmLoadFont = generateMenuItem("Load font");
        JMenuItem jmSettings = generateMenuItem("Settings");
        fileMenuItems.add(jmLoadFont);
        fileMenuItems.add(jmSettings);

        ArrayList<JMenuItem> viewMenuItems = new ArrayList<>();
        JMenuItem jmSetBg = generateMenuItem("Background color");
        JMenuItem jmSetFg = generateMenuItem("Foreground color");
        viewMenuItems.add(jmSetBg);
        viewMenuItems.add(jmSetFg);

        // JMenu instances:
        JMenu fileMenu = generateMenu("File", fileMenuItems);
        JMenu viewMenu = generateMenu("View", viewMenuItems);

        // Adding JMenus to JMenuBar:
        jmbMenu.add(fileMenu);
        jmbMenu.add(viewMenu);

        // Adding JMenuBar to the panel:
        add(jmbMenu, BorderLayout.LINE_START);
    }

    private JMenu generateMenu(String title, ArrayList<JMenuItem> menuItems) {
        JMenu menu = new JMenu(title);
        menu.setBorderPainted(false);
        menu.getPopupMenu().setBorder(null);
        menu.setFont(new Font("Courier", Font.BOLD, 10));
        menu.setForeground(Palette.middleRedPurple);
        for(int i = 0; i < menuItems.size(); i++)
            menu.add(menuItems.get(i));
        return menu;
    }

    private JMenuItem generateMenuItem(String title) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setBorderPainted(false); // or create a line border.
        menuItem.setBackground(Palette.paynesGrey);
        menuItem.setFont(new Font("Courier", Font.BOLD, 10));
        menuItem.setForeground(Palette.middleRedPurple);
        return menuItem;
    }
}
