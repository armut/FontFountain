package selector;

import fountain.FontFountain;
import fountain.PreviewPanel;
import main.Observer;
import main.Subject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * zamma on 29.03.2017.
 */
public class FontListHandler implements Subject, ListSelectionListener, MouseListener {
    private ArrayList<Observer> observers;
    private JTable fontsTable;
    private FontTableModel tableModel;

    public FontListHandler(JTable fontsTable, FontTableModel tableModel) {
        observers = new ArrayList<>();
        this.fontsTable = fontsTable;
        this.tableModel = tableModel;
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
        notifyObservers((Font) tableModel.getValueAt(
                fontsTable.getSelectedRow(),
                fontsTable.getSelectedColumn() + 1
        ));
        //TODO: This method runs two times when the value is changed. Why?
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Font font) {
        for(Observer o : observers) {
            o.update(font);
        }
    }

    @Override
    public void notifyObservers(int size) {

    }
}
