import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainMenu extends MenuBase {

    public MainMenu() {
        super();

        // JMenu instances:
        JMenu fileMenu = generateMenu("FILE", generateFileMenu());
        JMenu viewMenu = generateMenu("VIEW", generateViewMenu());
        JMenu editMenu = generateMenu("EDIT", generateEditMenu());

        // Adding JMenus to JMenuBar:
        getMenuBar().add(fileMenu);
        getMenuBar().add(viewMenu);
        getMenuBar().add(editMenu);

        // Adding JMenuBar to the panel:
        add(getMenuBar(), BorderLayout.LINE_START);
    }

    private ArrayList<JMenuItem> generateFileMenu() {
        ArrayList<JMenuItem> fileMenuItems = new ArrayList<>();
        JMenuItem jmLoadFont = generateMenuItem("LOAD FONT");
        JMenuItem jmDump = generateMenuItem("DUMP FONT LIST");
        JMenuItem jmSettings = generateMenuItem("SETTINGS");
        fileMenuItems.add(jmLoadFont);
        fileMenuItems.add(jmDump);
        fileMenuItems.add(jmSettings);
        for(JMenuItem item : fileMenuItems)
            item.addActionListener(this);
        return fileMenuItems;
    }

    private ArrayList<JMenuItem> generateViewMenu() {
        ArrayList<JMenuItem> viewMenuItems = new ArrayList<>();
        JMenuItem jmSelector = generateMenuItem("FONT SELECTOR");
        JMenuItem jmComparator = generateMenuItem("FONT COMPARATOR");
        JMenuItem jmComposer = generateMenuItem("COMPOSER");
        viewMenuItems.add(jmSelector);
        viewMenuItems.add(jmComparator);
        viewMenuItems.add(jmComposer);
        for(JMenuItem item : viewMenuItems)
            item.addActionListener(this);
        return viewMenuItems;
    }

    private ArrayList<JMenuItem> generateEditMenu() {
        ArrayList<JMenuItem> editMenuItems = new ArrayList<>();
        JMenuItem jmSetBg = generateMenuItem("BACKGROUND COLOR");
        JMenuItem jmSetFg = generateMenuItem("FOREGROUND COLOR");
        JMenuItem jmSetSize = generateMenuItem("DISPLAY SIZE");
        editMenuItems.add(jmSetSize);
        editMenuItems.add(jmSetBg);
        editMenuItems.add(jmSetFg);
        for(JMenuItem item : editMenuItems)
            item.addActionListener(this);
        return editMenuItems;
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