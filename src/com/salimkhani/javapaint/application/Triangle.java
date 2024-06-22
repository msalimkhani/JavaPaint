package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape{
    public Point p1,p2,p3;

    public Triangle() {
        super();
        name = "Triangle_" + MyUtils.getRandomInt(10000);
        p1 = new Point();
        p2 = new Point();
        p3 = new Point();
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
        System.out.printf("%s draw at %s -> %s -> %s\n", name, p1, p2,p3);

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

    @Override
    public boolean hit(Point p) {
        return false;
    }
    
}
