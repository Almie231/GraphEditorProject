package cz.uhk.graphed.model;

import java.awt.*;

public class Triangle extends AbstractGraphicObject{
    protected int a;
    public int getA(){
        return a;
    }

    public void setA(int a){
        this.a = a;
    }

    public Triangle(Point point, Color black){
    }

    public Triangle (Point pozition, Color color, int a){
        super(pozition,color);
        this.a = a;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        int v = (int)(a*Math.sqrt(3)/2);
        //bod [pos.x, pos.y] je levy dolni roh
        int [] xPoints = {
                pozition.x,
                pozition.x+(a/2),
                pozition.x+a,
        };
        int [] yPoints = {
                pozition.y + v,
                pozition.y,
                pozition.y + v,
        };
        g2d.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
