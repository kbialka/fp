package model.interfaces;

public interface ISubject {
    void registerObservers(IObserver observer);
    void notifyObservers();
}
