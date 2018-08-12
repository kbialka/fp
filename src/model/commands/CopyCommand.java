package model.commands;

import model.shape.Shape;
import model.util.ShapeList;
import model.util.ShapeListManager;

class CopyCommand implements ICommand {
    private ShapeList selected;
    private ShapeList clipboard;

    CopyCommand() {
        this.selected = ShapeListManager.getSelected();
        this.clipboard = ShapeListManager.getClipboard();
    }

    @Override
    public void run() {
        clipboard.clear();
        for (Shape shape : selected) {
            Shape copiedShape = new Shape(shape.getStart(), shape.getEnd(), shape.getShapeConfiguration());
            clipboard.add(copiedShape);
        }
    }
}
