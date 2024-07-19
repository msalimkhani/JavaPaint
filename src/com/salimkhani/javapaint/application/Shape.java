package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape{
    public String name;
    public Color borderColor;
    public Color fillColor;
    public boolean isFill;
    public boolean isBorder;
    protected java.awt.Shape sysShape;
    public Shape() {      
        borderColor = Color.black;
        fillColor = Color.white;
        isFill = false;
        isBorder = true;
    }

    public Shape(Color borderColor, Color fillColor, boolean isFill, boolean isBorder) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.isFill = isFill;
        this.isBorder = isBorder;
    }
    
    public abstract boolean select(Graphics gr, Point p);
    public abstract void draw(Graphics myGr);
    
    public abstract void move(int xMove, int yMove);
    public abstract void zoomIn(double factor);
    public abstract void erase();
    public abstract Shape copy();
    public abstract boolean hit(Point p);
}
