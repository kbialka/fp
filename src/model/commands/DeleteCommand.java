package model.commands;

import model.shape.Shape;
import model.util.ShapeList;
import model.util.ShapeListManager;

class DeleteCommand implements ICommand, IUndoable {
    private ShapeList master;
    private ShapeList selected;
    private ShapeList deleted = new ShapeList();

    DeleteCommand() {
        this.master = ShapeListManager.getMaster();
        this.selected = ShapeListManager.getSelected();
    }

    @Override
    public void run() {
        for (Shape shape : selected) {
            master.remove(shape);
            deleted.add(shape);
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        for (Shape shape : deleted) {
            master.add(shape);
        }
    }

    @Override
    public void redo() {
        for (Shape shape : deleted) {
            master.remove(shape);
        }
    }
}
