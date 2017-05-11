package selector;

import fountain.FontFountain;
import fountain.PreviewPanel;
import main.Observer;
import main.Subject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * zamma on 29.03.2017.
 */
public class FontSizeListHandler implements ListSelectionListener, Subject {
    private ArrayList<Observer> observers;
    private JList<String> sizeList;
    public FontSizeListHandler(JList<String> sizeList) {
        this.sizeList = sizeList;
        observers = new ArrayList<>();
    }
    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        notifyObservers(Integer.parseInt(sizeList.getSelectedValue()));
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

    }

    @Override
    public void notifyObservers(int size) {
        for(Observer o : observers)
            o.update(size);
    }

}
