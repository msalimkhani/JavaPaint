package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Shape{
    public Point p1,p2,p3;

    public Triangle() {
        super();
        name = "Triangle_" + MyUtils.getRandomInt(10000);
        p1 = new Point();
        p2 = new Point();
        p3 = new Point();
    }
    public static Triangle New(Point p1, Point p2, Point p3, Color borderColor, Color fillColor, boolean isFill, boolean  isBorder)
    {
        return new Triangle(p1, p2, p3, borderColor, fillColor, isFill, isBorder);
    }
    public Triangle(Point p1, Point p2, Point p3, Color borderColor, Color fillColor, boolean isFill, boolean  isBorder) {
        super(borderColor,fillColor,isFill, isBorder);
        name = "Triangle_" + MyUtils.getRandomInt(10000);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    
    
    @Override
    public void draw(Graphics myGr) {
        var g2d = (Graphics2D) myGr;
        int[] xPoints = {p1.getX(), p2.getX(), p3.getX()};
        int[] yPoints = {p1.getY(), p2.getY(), p3.getY()};
        if(isBorder && !isFill)
        {
            g2d.setColor(borderColor);
            g2d.drawPolygon(xPoints, yPoints, 3);
        }
        else if(!isBorder && isFill)
        {
            g2d.setColor(fillColor);
            g2d.fillPolygon(xPoints, yPoints, 3);
        }
        else if(isBorder && isFill)
        {
            g2d.setColor(borderColor);
            g2d.drawPolygon(xPoints, yPoints, 3);
            g2d.setColor(fillColor);
            g2d.fillPolygon(xPoints, yPoints, 3);
        }
        else {
            g2d.setColor(borderColor);
            g2d.drawPolygon(xPoints, yPoints, 3);
        }
    }

    @Override
    public void move(int xMove, int yMove) {
        p1.setX(p1.getX() + xMove);
        p1.setY(p1.getY() + yMove);
        p2.setX(p2.getX() + xMove);
        p2.setY(p2.getY() + yMove);
        p3.setX(p3.getX() + xMove);
        p3.setY(p3.getY() + yMove);
    }

    @Override
    public void erase() {
        System.out.printf("%s erased\n",name);
    }
    private double area(int x1, int y1, int x2, int y2, int x3, int y3)
    {
       return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }
    @Override
    public boolean hit(Point p) {
        
        double A = area (p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
      
        double A1 = area (p.getX(), p.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
      
        double A2 = area (p1.getX(), p1.getY(), p.getX(), p.getY(), p3.getX(), p3.getY());
      
        double A3 = area (p1.getX(), p1.getY(), p2.getX(), p2.getY(), p.getX(), p.getY());
        return (A == A1 + A2 + A3);
    }

    @Override
    public boolean select(Graphics gr, Point p) {
        var g2d = (Graphics2D) gr;
        int[] xPoints = {p1.getX(), p2.getX(), p3.getX()};
        int[] yPoints = {p1.getY(), p2.getY(), p3.getY()};
        if(hit(p))
        {
            g2d.setColor(Color.cyan);
            g2d.fillPolygon(xPoints, yPoints, 3);
            return true;
        }
        return false;
    }

    @Override
    public Shape copy() {
        return new Triangle(p1, p2, p3, borderColor, fillColor, isFill, isBorder);
    }
    
}
