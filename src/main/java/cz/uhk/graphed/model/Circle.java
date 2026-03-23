package cz.uhk.graphed.model;

import java.awt.*;

public class Circle extends AbstractGraphicObject{
    protected int r;
    public int getR() {
        return r;
    }
    public void setR(int r){
        this.r = r;
    }

    public Circle(){}

    public Circle(Point pozition, Color color, int r){
        super(pozition,color);
        this.r=r;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        //prumer je 2*r
        g2d.drawOval(pozition.x, pozition.y, r*2, r*2);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
