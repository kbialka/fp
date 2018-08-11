package model.observers;

public interface ISubject {
    void registerObservers(IObserver observer);
    void notifyObservers();
}
