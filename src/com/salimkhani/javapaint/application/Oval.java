/*
 * Mahdi Salimkhani

 */
package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author mahdi
 */
public class Oval extends Shape{

    private Point p1, p2, center;
    private int a, b;
    public Oval()
    {
        super();
        p1 = new Point();
        p2 = new Point();
        center = new Point();
    }
    public Oval(Point p1, Point p2, Color borderColor, Color fillColor, boolean isFill, boolean isBorder)
    {
        super(borderColor, fillColor, isFill, isBorder);
        this.p1 = p1;
        this.p2 = p2;
        calculateParameters();
    }
    private void calculateParameters()
    {
        setPoints();
        b = (p2.getX() - p1.getX()) / 2;
        a = (p2.getY() - p1.getY()) / 2;
        center = Point.New(p1.getX() + b, p2.getY() - a);
    }
    public static Oval New(Point p1, Point p2, Color borderColor, Color fillColor, boolean isFill, boolean isBorder)
    {
        return new Oval(p1, p2, borderColor, fillColor, isFill, isBorder);
    }
    private void setPoints(){
        if (p1.getX() > p2.getX()){
            int t = p1.getX();
            p1.setX(p2.getX());
            p2.setX(t);
        }
        
        if (p1.getY() > p2.getY()){
            int t = p1.getY();
            p1.setY(p2.getY());
            p2.setY(t);
        }
    }
    @Override
    public void draw(Graphics myGr) {
        calculateParameters();
        var g2d = (Graphics2D) myGr;
        if (isFill && !isBorder){
            g2d.setColor(fillColor);
            g2d.fillOval(p1.getX(), p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
            
        }else if(!isFill && isBorder){
            
            g2d.setColor(borderColor);
            g2d.drawOval(p1.getX(), p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
        }
        else if(isFill && isBorder)
        {
            g2d.setColor(fillColor);
            g2d.fillOval(p1.getX(), p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
            g2d.setColor(borderColor);
            //radius +=0.5;
            g2d.drawOval(p1.getX(), p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
        }
        else
        {
            g2d.setColor(borderColor);
            g2d.drawOval(p1.getX(), p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
        }
        //System.out.println("Oval : " + p1 + "-->" + p2 + " { a = " + a + ", b = " + b + ", center = " + center + " } ");
    }

    @Override
    public void move(int xMove, int yMove) {
        p1.setX(p1.getX() + xMove);
        p1.setY(p1.getY() + yMove);
        p2.setX(p2.getX() + xMove);
        p2.setY(p2.getY() + yMove);
    }

    @Override
    public void erase() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public boolean hit(Point p) {
        return ((Math.pow(p.getX() - center.getX(), 2)) / (Math.pow(a, 2)) + (Math.pow(p.getY() - center.getY(), 2)) / (Math.pow(b, 2))) <= 1;
    }

    @Override
    public boolean select(Graphics gr, Point p) {
        var g2d = (Graphics2D) gr;
        if(hit(p))
        {
            g2d.setColor(Color.gray);
            g2d.drawRect(p1.getX() + 1, p1.getY() + 1, 1 + (p2.getX()-p1.getX()), 1 + (p2.getY()-p1.getY()));
            return true;
        }
        return false;
    }


    @Override
    public Shape copy() {
        return Oval.New(Point.New(p1.getX(), p1.getY()), Point.New(p2.getX(), p2.getY()), borderColor, fillColor, isFill, isBorder);
    }
}
