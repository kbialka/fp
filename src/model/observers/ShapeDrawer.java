package model.observers;

import model.shape.Shape;
import model.shape.featureEnums.ShapeType;
import model.interfaces.IObserver;
import model.util.ShapeList;
import view.gui.PaintCanvas;

import java.awt.*;

public class ShapeDrawer implements IObserver {
    private PaintCanvas canvas;

    public ShapeDrawer(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void update(ShapeList shapeList) {
        for (Shape shape : shapeList) {
            Graphics2D graphic = canvas.getGraphics2D();
            ShapeType type = shape.getShapeType();

            switch (type) {
                case ELLIPSE:
                    graphic.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                    break;
                case RECTANGLE:
                    graphic.drawRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                    break;
                default:
                    graphic.drawPolygon(shape.getXS(), shape.getYS(), 3);
                    break;
            }
        }
    }


}
