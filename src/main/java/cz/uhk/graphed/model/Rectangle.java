package cz.uhk.graphed.model;

import java.awt.*;

public class Rectangle extends AbstractGraphicObject {
    protected int a;
    protected int b;

    public int GetA() {
        return a;
    }

    public int GetB() {
        return b;
    }

    public void SetA(int a) {
        this.a = a;
    }

    public void SetB(int b) {
        this.b = b;
    }

    public Rectangle() {
    }

    public Rectangle(Point position, Color color, int width, int height) {
        super(position, color);
        this.a = width;
        this.b = height;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawRect(position.x, position.y, a, b);
    }

    @Override
    public boolean contains(Point p) {
        return p.x >= position.x && p.x <= position.x + a && p.y >= position.y && p.y <= position.y + b;
    }
}
