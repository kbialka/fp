package model.commands;

import model.shape.Shape;
import model.util.Pair;
import model.util.ShapeList;

import java.io.IOException;

public class MoveShapeCommand implements ICommand {
    private Pair start;
    private Pair end;
    private ShapeList master;
    private ShapeList selected;

    MoveShapeCommand(Pair start, Pair end, ShapeList master, ShapeList selected) {
        this.start = start;
        this.end = end;
        this.master = master;
        this.selected = selected;
    }

    @Override
    public void run() throws IOException {
        int selectedIdx = 0;
        for (Shape shape : selected) {
            int masterIdx = master.indexOf(shape);
            // to maintain existing size/shape
            Pair newEnd = new Pair(start.getX()+shape.getWidth(), start.getY()+shape.getHeight());
            Shape newShape = new Shape(start, newEnd, shape.getShapeConfiguration());
            master.set(masterIdx, newShape);
            selected.set(selectedIdx, newShape);
            selectedIdx++;
        }
    }
}
