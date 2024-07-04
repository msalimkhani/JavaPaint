package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape{
    public Point center;
    public int radius;
    
    public Circle() {
        super();
        name = "Circle_" + MyUtils.getRandomInt(10000);
        this.center = new Point();
        this.radius = 1;
        
    }
    public static Circle New(Point center, int radius, Color borderColor, Color fillColor, boolean isFill, boolean  isBorder)
    {
        return new Circle(center, radius, borderColor, fillColor, isFill, isBorder);
    }
    public Circle(Point center, int radius, Color borderColor, Color fillColor, boolean isFill, boolean  isBorder) {
        super(borderColor,fillColor,isFill, isBorder);
        name = "Circle_" + MyUtils.getRandomInt(10000);
        this.center = center;
        this.radius = radius;
        
    }
    
    public void draw(Graphics myGr) {
        if (isFill && !isBorder){
            myGr.setColor(fillColor);
            myGr.fillOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
            
        }else if(!isFill && isBorder){
            
            myGr.setColor(borderColor);
            myGr.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
        }
        else if(isFill && isBorder)
        {
            myGr.setColor(fillColor);
            myGr.fillOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
            myGr.setColor(borderColor);
            //radius +=0.5;
            myGr.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
        }
        else
        {
            myGr.setColor(borderColor);
            myGr.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
        }
    }

    public void move(int xMove, int yMove) {
        center.setX(center.getX() + xMove);
        center.setY(center.getY() + yMove);
    }
    
    public void erase(){
        System.out.printf("%s erased\n",name);
    }
    public boolean select(Graphics gr, Point p)
    {
        var g2d = (Graphics2D) gr;
        if(hit(p))
        {
            g2d.setColor(Color.gray);
            g2d.drawRect(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
            return true;
        }
        return false;
    }
    public boolean hit(Point p){
        return center.distance(p)<= radius;
    }

    @Override
    public Shape copy() {
        
        return new Circle(Point.New(center.getX(), center.getY()), radius, borderColor, fillColor, isFill, isBorder);
    }

    
    
}
