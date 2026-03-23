package cz.uhk.graphed.model;

import java.awt.*;

public class Circle extends AbstractGraphicObject {
    protected int r;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Circle() {
    }

    public Circle(Point position, Color color, int r) {
        super(position, color);
        this.r = r;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //prumer je 2*r
        g2d.drawOval(position.x, position.y, r * 2, r * 2);
    }

    @Override
    public boolean contains(Point p) {
        int x0 = position.x + r;
        int y0 = position.y + r;
        return (p.x - x0) * (p.x - x0) + (p.y - y0) * (p.y - y0) <= r * r;
    }
}
