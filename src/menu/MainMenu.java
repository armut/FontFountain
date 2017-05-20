package menu;

import fountain.FontFountain;
import main.FontFilter;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
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
        //JMenuItem jmDump = generateMenuItem("DUMP FONT LIST");
        fileMenuItems.add(jmLoadFont);
        //fileMenuItems.add(jmDump);
        for(JMenuItem item : fileMenuItems)
            item.addActionListener(this);
        return fileMenuItems;
    }

    private ArrayList<JMenuItem> generateViewMenu() {
        ArrayList<JMenuItem> viewMenuItems = new ArrayList<>();
        JMenuItem jmSelector = generateMenuItem("FONT SELECTOR");
        JMenuItem jmSetSize = generateMenuItem("FONT SIZE");
        viewMenuItems.add(jmSelector);
        viewMenuItems.add(jmSetSize);
        for(JMenuItem item : viewMenuItems)
            item.addActionListener(this);
        return viewMenuItems;
    }

    private ArrayList<JMenuItem> generateEditMenu() {
        ArrayList<JMenuItem> editMenuItems = new ArrayList<>();
        JMenuItem jmSetBg = generateMenuItem("BACKGROUND COLOR");
        JMenuItem jmSetFg = generateMenuItem("FONT COLOR");
        editMenuItems.add(jmSetBg);
        editMenuItems.add(jmSetFg);
        for(JMenuItem item : editMenuItems)
            item.addActionListener(this);
        return editMenuItems;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("FONT SELECTOR")) {
            if( Main.fontSelectorDialog.isVisible()) {
                Main.fontSelectorDialog.setVisible(false);
            } else {
                Main.fontSelectorDialog.setVisible(true);
            }
        } else if(e.getActionCommand().equals("FONT SIZE")) {
            if( Main.fontSizeDialog.isVisible())
                Main.fontSizeDialog.setVisible(false);
            else
                Main.fontSizeDialog.setVisible(true);
        } else if(e.getActionCommand().equals("FONT COLOR")) {
            if( Main.fontColorChooserDialog.isVisible())
                Main.fontColorChooserDialog.setVisible(false);
            else
                Main.fontColorChooserDialog.setVisible(true);
        } else if(e.getActionCommand().equals("BACKGROUND COLOR")) {
            if( Main.backgroundColorChooserDialog.isVisible())
                Main.backgroundColorChooserDialog.setVisible(false);
            else
                Main.backgroundColorChooserDialog.setVisible(true);
        } else if(e.getActionCommand().equals("LOAD FONT")) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    final JFileChooser fc = new JFileChooser();
                    fc.addChoosableFileFilter(new FontFilter());
                    fc.setAcceptAllFileFilterUsed(false);
                    int result = fc.showOpenDialog(null);
                    if(result == JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();
                        try {
                            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(
                                    Font.createFont(Font.TRUETYPE_FONT, file)
                            );
                        } catch (FontFormatException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override
    public void notifyObservers(int dummy) {

    }
}
