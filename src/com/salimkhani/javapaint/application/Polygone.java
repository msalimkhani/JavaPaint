/*
 * Mahdi Salimkhani

 */
package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author mahdi
 */
public class Polygone extends Shape{

    private ArrayList<Point> points;
    public  Polygone(ArrayList<Point> polyPoints, Color borderColor, Color fillColor, boolean isFill, boolean isBorder)
    {
        super(borderColor, fillColor, isFill, isBorder);
        points = new ArrayList<>();
        points.addAll(polyPoints);
    }
    public static Polygone New(ArrayList<Point> polyPoints, Color borderColor, Color fillColor, boolean isFill, boolean isBorder)
    {
        return new Polygone(polyPoints, borderColor, fillColor, isFill, isBorder);
    }
    @Override
    public void draw(Graphics myGr) {
        var g2d = (Graphics2D) myGr;
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for(int i = 0; i < xPoints.length; i++)
        {
            xPoints[i] = points.get(i).getX();
            yPoints[i] = points.get(i).getY();
        }
        if(isBorder && !isFill)
        {
            g2d.setColor(borderColor);
            g2d.drawPolygon(xPoints, yPoints, xPoints.length);
        }
        else if(!isBorder && isFill)
        {
            g2d.setColor(fillColor);
            g2d.fillPolygon(xPoints, yPoints, xPoints.length);
        }
        else if(isBorder && isFill)
        {
            g2d.setColor(borderColor);
            g2d.drawPolygon(xPoints, yPoints, xPoints.length);
            g2d.setColor(fillColor);
            g2d.fillPolygon(xPoints, yPoints, xPoints.length);
        }
        else {
            g2d.setColor(borderColor);
            g2d.drawPolygon(xPoints, yPoints, xPoints.length);
        }
        System.out.println("Polygone : " + xPoints.length + " Color : " + borderColor + ", " + fillColor);
    }

    @Override
    public void move(int xMove, int yMove) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void erase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean hit(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean select(Graphics gr, Point p) {
        var g2d = (Graphics2D) gr;
        if(hit(p))
        {
            return true;
        }
        return false;
    }

    @Override
    public Shape copy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
