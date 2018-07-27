package model.mouseHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import model.Shape;
import model.StartAndEndPointMode;
import model.commands.DrawCommand;
import model.interfaces.ICommand;
import util.Pair;
import model.interfaces.IApplicationState;
import util.ShapeList;

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
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Pair end = new Pair(e.getX(), e.getY());

        // this will create the commends
        ICommand command;

        if (appState.getActiveStartAndEndPointMode() == StartAndEndPointMode.DRAW) {
            // draw test
            command = new DrawCommand(new Shape(start, end, appState.getCurrentConfiguration()), shapeList);
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
