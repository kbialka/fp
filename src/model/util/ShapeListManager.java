package model.util;

public class ShapeListManager {
    private static final ShapeList master = new ShapeList();
    private static final ShapeList selected = new ShapeList();
    private static final ShapeList clipboard = new ShapeList();

    public static ShapeList getMaster() {
        return master;
    }

    public static ShapeList getSelected() {
        return selected;
    }

    public static ShapeList getClipboard() {
        return clipboard;
    }
}
