package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PaintingArea {

    public ArrayList<Shape> shapeArr;
    public Graphics myGr;
    public int height, width;

    public PaintingArea(Graphics myGr,int height, int width) {
        shapeArr = new ArrayList();
        this.myGr = myGr; 
        this.height = height;
        this.width = width;
        
    }
    
    public void addShape(Shape s) {
        shapeArr.add(s);
        s.draw(myGr);
    }

    public int indexOf(Shape s) {
        int index = shapeArr.indexOf(s);
        return index;
    }

    public Shape removeShape(Shape s) {

        int idx = indexOf(s);
        Shape removedItem = shapeArr.remove(idx);
        reDrawAll();
        return removedItem;
    }

    public void reDrawAll(){
        myGr.setColor(Color.white);
        myGr.fillRect(0, 0, width, height);
        for (Shape s : shapeArr) {
            s.draw(myGr);
        }
    }
    public void moveShape(Shape s, int xMove, int yMove) {
        int idx = indexOf(s);
        if (idx > -1) {
            s.move(xMove, yMove);
        }
        reDrawAll();
    }

    public Shape searchShapeByPoint(Point p) {
        Shape s = null;
        for (int i = 0; shapeArr != null && i < shapeArr.size(); i++) {
            if (shapeArr.get(i).hit(p)) {
                s = shapeArr.get(i);
                break;
            }

        }

        return s;
    }
    public Shape hitShapes(Point p)
    {
        for (Shape shape : shapeArr) {
            if(shape.hit(p))
                return shape;
        }
        return null;
    }
    public String getStatus() {
        int lCount = 0, rCount = 0, cCount = 0, tCount = 0;
        if (shapeArr != null) {
            for (Shape s : shapeArr) {
                if (s instanceof Line) {
                    lCount++;
                } else if (s instanceof Rectangle) {
                    rCount++;

                } else if (s instanceof Circle) {
                    cCount++;
                } else if (s instanceof Triangle) {
                    tCount++;
                }

            }
        }

        return String.format("Lines: %d, Rectangles: %d, Circles: %d, Triangle: %d", lCount, rCount, cCount, tCount);
    }

}
