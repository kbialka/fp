package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import model.commands.ICommandFactory;
import model.shape.Shape;
import model.shape.featureEnums.StartAndEndPointMode;
import model.commands.CreateShapeCommand;
import model.commands.ICommand;
import model.util.Pair;
import model.interfaces.IApplicationState;
import model.util.ShapeList;

public class MouseHandler extends MouseAdapter {
    private IApplicationState appState;
    private Pair start;
    private ShapeList shapeList;

    public MouseHandler(IApplicationState appState, ShapeList shapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.start = new Pair(e.getX(), e.getY());
        System.out.println();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Pair end = new Pair(e.getX(), e.getY());
        System.out.println();

        // this will create the commends
        ICommand command;

        if (appState.getActiveStartAndEndPointMode() == StartAndEndPointMode.DRAW) {
            // draw test
            //command = new CreateShapeCommand(new Shape(start, end, appState.getCurrentConfiguration()), shapeList);
            command = ICommandFactory.createShapeCommand(start, end, appState.getCurrentConfiguration(), shapeList);
            // MOVE THIS OUT OF BRANCH ONCE BELOW ARE IMPLEMENTED
            try {
                command.run();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (appState.getActiveStartAndEndPointMode() == StartAndEndPointMode.MOVE) {
            System.out.println("Move test");
        } else {
            System.out.println("Select Test");
        }

        // run the selected command
        // command.run() //commented out for now
    }
}
