package cz.uhk.graphed.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * seskupeni grafickych objektu
 */

public class GraphicGroup extends AbstractGraphicObject {
    List<AbstractGraphicObject> items = new ArrayList<>();

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        items.forEach(item -> {item.draw(g2d);});
    }

    @Override
    public boolean contains(Point p) {
        for (var it : items) {
            if (it.contains(p)) {
                return true;
            }
        }
        return false;

    }
    public GraphicGroup() {
        position = new Point(0, 0);
    }
    public void add(AbstractGraphicObject obj) {
        items.add(obj);
    }
    public void move (int dx, int dy) {
        super.move(dx, dy);
        items.forEach(it -> it.move(dx, dy));
    }
}
