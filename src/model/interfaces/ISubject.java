package model.interfaces;

import model.Shape;

public interface ISubject {
    void registerObservers(IObserver observer);
    void notifyObservers();
}
