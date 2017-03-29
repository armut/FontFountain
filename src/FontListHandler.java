import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * zamma on 29.03.2017.
 */
public class FontListHandler implements ListSelectionListener, MouseListener {
    private JList<String> listBox;
    private ArrayList<Font> fontsList;

    public FontListHandler(JList<String> listBox, ArrayList<Font> fontsList) {
        this.listBox = listBox;
        this.fontsList = fontsList;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.isPopupTrigger()) {
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
            contextMenu.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        FontFountain.currentFont = fontsList.get(listBox.getSelectedIndex());
        //TODO: new Font(...) part of the below have to be beautified.
        PreviewPanel.textPane.setFont(new Font(FontFountain.currentFont.getName(), Font.PLAIN, 72));
        //TODO: This method runs two times when the value is changed. Why?
    }
}
