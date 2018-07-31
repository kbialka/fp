package util;

import model.Shape;
import model.interfaces.IObserver;
import model.interfaces.ISubject;
import java.util.ArrayList;
import java.util.List;

public class ShapeList extends ArrayList<Shape> implements ISubject {
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public boolean add(Shape e) {
        super.add(e);
        this.notifyObservers();
        return true;
    }

    @Override
    public void registerObservers(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : observers) {
            observer.update(this);
        }
    }
}
