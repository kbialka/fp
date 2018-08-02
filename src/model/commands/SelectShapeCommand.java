package model.commands;

import model.shape.Shape;
import model.util.CollisionDetector;
import model.util.Pair;
import model.util.ShapeList;

import java.io.IOException;

public class SelectShapeCommand implements ICommand {
    private Pair start;
    private Pair end;
    private ShapeList masterShapeList;
    private ShapeList selectedShapeList;

    public SelectShapeCommand(Pair start, Pair end, ShapeList masterShapeList, ShapeList selectedShapeList) {
        this.start = start;
        this.end = end;
        this.masterShapeList = masterShapeList;
        this.selectedShapeList = selectedShapeList;
        this.selectedShapeList.clear();
    }

    @Override
    public void run() throws IOException {
        for(Shape shape:masterShapeList) {
            if (CollisionDetector.detect(start, end, shape)) {
                selectedShapeList.add(shape);
            }
        }
    }
}
