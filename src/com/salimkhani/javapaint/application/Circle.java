package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;

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
    
    public boolean hit(Point p){
        return center.distance(p)<= radius;
    }

    
    
}
