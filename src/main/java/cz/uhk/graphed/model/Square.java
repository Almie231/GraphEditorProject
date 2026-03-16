package cz.uhk.graphed.model;

import java.awt.*;

public class Square extends AbstractGraphicObject {

    protected int a;

    public Square() {
    }

    public Square(Point pozition, Color color, int a) {
        super(pozition, color);
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }


    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawRect(pozition.x, pozition.y, a, a);

    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
