package model.commands;

import model.shape.Shape;
import model.util.Pair;
import model.util.ShapeList;
import model.util.ShapeListManager;

class PasteCommand implements ICommand {
    private ShapeList master;
    private ShapeList clipboard;

    PasteCommand() {
        this.master = ShapeListManager.getMaster();
        this.clipboard = ShapeListManager.getClipboard();
    }

    @Override
    public void run() {
        for (Shape shape : clipboard) {
            // just pastes to (0,0) start point retaining dimensions
            Pair start = new Pair(0,0);
            Pair end = new Pair(shape.getWidth(), shape.getHeight());
            Shape toPaste = new Shape(start, end, shape.getShapeConfiguration());
            master.add(toPaste);
        }

    }
}
