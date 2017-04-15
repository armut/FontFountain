package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FontSelectorMenu extends MenuBase {

    public FontSelectorMenu() {
        super();
        JMenu fileMenu = generateMenu("FILE", generateFileMenu());
        getMenuBar().add(fileMenu);
        add(getMenuBar(), BorderLayout.LINE_START);
    }

    private ArrayList<JMenuItem> generateFileMenu() {
        ArrayList<JMenuItem> fileMenuItems = new ArrayList<>();
        JMenuItem jmRefresh = generateMenuItem("REFRESH");
        JMenuItem jmRearrange = generateMenuItem("REARRANGE");
        fileMenuItems.add(jmRefresh);
        fileMenuItems.add(jmRearrange);
        for(JMenuItem item : fileMenuItems)
            item.addActionListener(this);
        return fileMenuItems;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
