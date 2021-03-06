package fountain;

import fenestra.Palette;
import main.Observer;
import main.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class PreviewPanel extends JPanel implements Subject {
    private ArrayList<Observer> observers;
    private static JTextPane textPane;
    private JScrollPane scrollPane;
    private String quote = "Don Quixote";

    public PreviewPanel() {
        observers = new ArrayList<>();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Palette.deepTaupe);

        textPane = new JTextPane();
        textPane.setText(quote);
        textPane.setBackground(Palette.mistyRose);
        textPane.setFont(FontFountain.currentFont);
        textPane.addMouseWheelListener(new WheelHandler());

        scrollPane = new JScrollPane(textPane);
        add(scrollPane);
    }

    public static void setPreviewPanelFont(Font font) {
        textPane.setFont(font);
    }

    public JTextPane getTextPane() {
        return textPane;
    }

    private class WheelHandler implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
            int notches = mouseWheelEvent.getWheelRotation();
            if(notches < 0) {
                notifyObservers(++FontFountain.currentFontSize);
                Font increasedFont = new Font(FontFountain.currentFont.getName(),
                        Font.PLAIN, FontFountain.currentFontSize);
                setPreviewPanelFont(increasedFont);
            } else {
                notifyObservers(--FontFountain.currentFontSize);
                Font decreasedFont = new Font(FontFountain.currentFont.getName(),
                        Font.PLAIN, FontFountain.currentFontSize);
                setPreviewPanelFont(decreasedFont);
            }
        }
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
