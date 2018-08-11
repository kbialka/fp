package model.observers;

import model.shape.Shape;
import model.shape.ShapeColorMap;
import model.shape.featureEnums.ShapeShadingType;
import model.shape.featureEnums.ShapeType;
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

        Graphics2D graphic = canvas.getGraphics2D();
        Rectangle border = canvas.getBounds();
        canvas.paintImmediately(border);

        for (Shape shape : shapeList) {
            ShapeType type = shape.getShapeType();
            ShapeShadingType fill = shape.getFill();

            switch (type) {
                case ELLIPSE:
                    switch (fill) {
                        case OUTLINE:
                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                            break;
                        case FILLED_IN:
                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                            break;
                        default:
                            graphic.setColor(ShapeColorMap.get(shape.getSecondary()));
                            graphic.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());

                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                            break;
                    }
                    break;

                case RECTANGLE:
                    switch (fill) {
                        case OUTLINE:
                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.drawRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                            break;
                        case FILLED_IN:
                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                            break;
                        default:
                            graphic.setColor(ShapeColorMap.get(shape.getSecondary()));
                            graphic.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());

                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.drawRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
                            break;
                    }
                    break;

                default:
                    switch (fill) {
                        case OUTLINE:
                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.drawPolygon(shape.getXS(), shape.getYS(), 3);
                            break;
                        case FILLED_IN:
                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.fillPolygon(shape.getXS(), shape.getYS(), 3);
                            break;
                        default:
                            graphic.setColor(ShapeColorMap.get(shape.getSecondary()));
                            graphic.fillPolygon(shape.getXS(), shape.getYS(), 3);

                            graphic.setColor(ShapeColorMap.get(shape.getPrimary()));
                            graphic.drawPolygon(shape.getXS(), shape.getYS(), 3);
                            break;
                    }
                    break;

            }
        }
    }


}
