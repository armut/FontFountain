package main;

import java.awt.*;

/**
 * zamma on 08.05.2017.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(Font font);
}
