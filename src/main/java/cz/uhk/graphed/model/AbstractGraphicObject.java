package cz.uhk.graphed.model;

import java.awt.*;

public abstract class AbstractGraphicObject {
    protected Point pozition;
    protected Color color;

    public AbstractGraphicObject(Point pozition, Color color) {
        this.pozition = pozition;
        this.color = color;
    }

    public AbstractGraphicObject() {
    }

    public Point getPozition() {
        return pozition;
    }

    public void setPozition(Point pozition) {
        this.pozition = pozition;
    }

    public void setPozition(int x, int y) {
        setPozition(new Point(x, y));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public abstract void draw(Graphics g);

    public abstract boolean contains(Point p);

    public boolean contains(int x, int y) {
        return contains(new Point(x, y));
    }

}
