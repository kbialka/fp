package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import model.commands.ICommandFactory;
import model.shape.Shape;
import model.shape.featureEnums.StartAndEndPointMode;
import model.commands.ICommand;
import model.util.Pair;
import model.interfaces.IApplicationState;
import model.util.ShapeList;

public class MouseHandler extends MouseAdapter {
    private IApplicationState appState;
    private Pair start;
    private ShapeList masterShapeList;
    private ShapeList selectedShapeList;

    public MouseHandler(IApplicationState appState, ShapeList masterShapeList, ShapeList selectedShapeList) {
        this.appState = appState;
        this.masterShapeList = masterShapeList;
        this.selectedShapeList = selectedShapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // constants account for mouse pointer offset on GUI canvas
        this.start = new Pair(e.getX() - 6, e.getY() - 67);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // constants account for mouse pointer offset on GUI canvas
        Pair end = new Pair(e.getX() - 6, e.getY() - 67);

        // start is top left, end is bottom right of canvas
        Pair trueStart = getStart(start, end);
        Pair trueEnd = getEnd(start, end);

        // this will create the commends
        ICommand command;

        if (appState.getActiveStartAndEndPointMode() == StartAndEndPointMode.DRAW) {
            // draw test
            command = ICommandFactory.createShapeCommand(trueStart, trueEnd,
                    appState.getCurrentConfiguration(), masterShapeList);
            // MOVE THIS OUT OF BRANCH ONCE BELOW ARE IMPLEMENTED
            try {
                command.run();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (appState.getActiveStartAndEndPointMode() == StartAndEndPointMode.SELECT) {
            command = ICommandFactory.createSelectCommand(trueStart, trueEnd, masterShapeList, selectedShapeList);
            try {
                command.run();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            // command = ICommandFactory.createMoveCommand(trueStart, trueEnd, masterShapeLIst, selectedShapeList);
            System.out.println("Select Test");
        }

        // run the selected command
        // command.run() //commented out for now
    }

    private static Pair getStart(Pair p1, Pair p2) {
        // returns top left coordinates of box
        return new Pair((Math.min(p1.getX(), p2.getX())), (Math.min(p1.getY(), p2.getY())));
    }

    private static Pair getEnd(Pair p1, Pair p2) {
        // returns top left coordinates of box
        return new Pair((Math.max(p1.getX(), p2.getX())), (Math.max(p1.getY(), p2.getY())));
    }
}
