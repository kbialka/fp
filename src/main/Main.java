package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.observers.ShapeDrawer;
import model.persistence.ApplicationState;
import controller.MouseHandler;
import model.util.ShapeList;
import model.util.ShapeListManager;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas canvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        // create shapelist and clickhandler
        ShapeList masterShapeList = ShapeListManager.getMaster();
        ShapeList selectedShapeList = ShapeListManager.getSelected();
        MouseHandler mouseHandler = new MouseHandler(appState, masterShapeList, selectedShapeList);
        ((GuiWindow) guiWindow).addMouseListener(mouseHandler);

        // register observers with shapeList
        ShapeDrawer drawer = new ShapeDrawer(canvas);
        masterShapeList.registerObservers(drawer);

    }
}
