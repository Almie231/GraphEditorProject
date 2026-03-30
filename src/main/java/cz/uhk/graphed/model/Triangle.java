package cz.uhk.graphed.model;

import java.awt.*;

public class Triangle extends AbstractGraphicObject {
    protected int a;
    private int cx, cy; //pomocne souradnice vrcholu C

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private void computeC() {
        cx = position.x + (int) Math.round(a / 2.0);
        cy = position.y - (int) Math.round(a * (Math.sin(Math.PI / 3)));
    }

    public Triangle() {
    }

    public Triangle(Point pozition, Color color, int a) {
        super(pozition, color);
        this.a = a;
        computeC();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawLine(position.x, position.y, position.x + a, position.y);
        g2d.drawLine(position.x, position.y, cx, cy);
        g2d.drawLine(position.x + a, position.y, cx, cy);

    }

    @Override
    public boolean contains(Point p) {
        //rozpohybovat trojuhelnik pomoci dx a dy a tangens
        double dy = p.y - cy;
        double h = (a * Math.sqrt(3) / 2.0);
        if (dy < 0 || dy > h) {
            return false;
        }
        double dxMax = dy / Math.tan(Math.toRadians(60));
        return p.x >= (cx - dxMax) && p.x <= (cx + dxMax);
    }

    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
        computeC();

    }
    @Override
    public void move (int dx, int dy) {
        super.move(dx, dy);
        computeC();
    }
}
