package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shape{

    public Point p1, p2;

    public static Line New(Point p1, Point p2, Color borderColor)
    {
        return new Line(p1, p2, borderColor);
    }
    public Line() {
        super();
        name = "Line_" + MyUtils.getRandomInt(10000);
        p1 = new Point();
        p2 = new Point();
        
    }

    public Line(Point p1, Point p2, Color borderColor) {
        name = "Line_" + MyUtils.getRandomInt(10000);
        this.p1 = p1;
        this.p2 = p2;
        this.borderColor = borderColor;
    }

    public void draw(Graphics myGr) {
        var gr2d = (Graphics2D) myGr;
        myGr.setColor(borderColor);
        //myGr.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        gr2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        System.out.printf("%s draw at %s -> %s\n", name, p1, p2);
    }

    public void move(int xMove, int yMove) {
        p1.setX(p1.getX() + xMove);
        p1.setY(p1.getY() + yMove);
        p2.setX(p2.getX() + xMove);
        p2.setY(p2.getY() + yMove);

    }
    
    public void erase(){
        System.out.printf("%s erased\n",name);
    }
    
    public boolean hit(Point p){
        return p1.distance(p1) == p1.distance(p) + p2.distance(p);
    }

}
