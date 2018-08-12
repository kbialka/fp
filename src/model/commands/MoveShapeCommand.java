package model.commands;

import model.shape.Shape;
import model.util.Pair;
import model.util.ShapeList;

import java.io.IOException;
import java.util.ArrayList;

public class MoveShapeCommand implements ICommand, IUndoable {
    private Pair start;
    private Pair end;
    private ShapeList master;
    private ShapeList selected;
    private ArrayList<Integer> selectedIndices = new ArrayList<>();
    private ShapeList selectedOriginal = new ShapeList();

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
            // deep copy of selected for undo/redo
            Shape copy = new Shape(shape.getStart(), shape.getEnd(), shape.getShapeConfiguration());
            selectedOriginal.add(copy);
            //make changes to master
            master.set(masterIdx, newShape);
            selected.set(selectedIdx, newShape);
            selectedIdx++;
            selectedIndices.add(masterIdx);
        }
        System.out.println(selected.size());
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (int i = 0; i < selected.size(); i++) {
            master.set(selectedIndices.get(i), selectedOriginal.get(i));

        }
    }

    @Override
    public void redo() {
        for (int i = 0; i < selected.size(); i++) {
            master.set(selectedIndices.get(i), selected.get(i));
        }
    }
}
