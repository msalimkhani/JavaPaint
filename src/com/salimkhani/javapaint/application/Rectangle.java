package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
    public Point p1, p2;
    

    public Rectangle() {
        super();
        name = "Rectangle_" + MyUtils.getRandomInt(10000);
        p1 = new Point();
        p2 = new Point();
        
    }

    public Rectangle(Point p1, Point p2, Color borderColor,Color fillColor, boolean isFill, boolean  isBorder) {
        super(borderColor,fillColor,isFill, isBorder);
        name = "Rectangle_" + MyUtils.getRandomInt(10000);
        this.p1 = p1;
        this.p2 = p2;
        
    }
    
    public void draw(Graphics myGr) {
        setPoints();
        if (isFill && !isBorder){
            myGr.setColor(fillColor);
            myGr.fillRect(p1.getX(), p1.getY(), p2.getX()-p1.getX(), p2.getY()-p1.getY());
            
        }else if(!isFill && isBorder){
            
            myGr.setColor(borderColor);
            myGr.drawRect(p1.getX(), p1.getY(), p2.getX()-p1.getX(), p2.getY()-p1.getY());
        }
        else if(isFill && isBorder)
        {
            myGr.setColor(fillColor);
            myGr.fillRect(p1.getX(), p1.getY(), p2.getX()-p1.getX(), p2.getY()-p1.getY());
            myGr.setColor(borderColor);
            myGr.drawRect(p1.getX(), p1.getY(), p2.getX()-p1.getX(), p2.getY()-p1.getY());
        }
        else
        {
            myGr.setColor(borderColor);
            myGr.drawRect(p1.getX(), p1.getY(), p2.getX()-p1.getX(), p2.getY()-p1.getY());
        }
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
        return p.getX() >= p1.getX() && p.getX() <= p2.getX() 
                && p.getY() >= p1.getY() && p.getY() <= p2.getY();
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

}
