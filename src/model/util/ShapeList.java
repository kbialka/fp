package model.util;

import model.shape.Shape;
import model.observers.IObserver;
import model.observers.ISubject;
import java.util.ArrayList;
import java.util.List;

public class ShapeList extends ArrayList<Shape> implements ISubject {
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public boolean add(Shape e) {
        super.add(e);
        notifyObservers();
        return true;
    }


    public boolean remove(Shape shape) {
        super.remove(shape);
        notifyObservers();
        return true;
    }

    @Override
    public Shape set(int index, Shape shape) {
        Shape ret = super.set(index, shape);
        notifyObservers();
        return ret;
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
