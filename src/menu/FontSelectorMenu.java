package menu;

import main.Observer;
import selector.FontSelector;

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
        fileMenuItems.add(jmRefresh);
        for(JMenuItem item : fileMenuItems)
            item.addActionListener(this);
        return fileMenuItems;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("REFRESH")) {
            notifyObservers(1);
        }
    }

    @Override
    public void notifyObservers(int dummy) {
        for( Observer o : observers) {
            o.update(1);
        }
    }
}
