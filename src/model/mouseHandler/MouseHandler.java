package model.mouseHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import util.Pair;

public class MouseHandler extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        Pair start = new Pair(e.getX(), e.getY());
        // currently just printing - remove later
        System.out.println(start);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Pair end = new Pair(e.getX(), e.getY());
        // currently just printing - generate shape later
        System.out.println(end);
    }
}
