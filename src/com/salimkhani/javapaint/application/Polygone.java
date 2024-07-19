/*
 * Mahdi Salimkhani

 */
package com.salimkhani.javapaint.application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
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
        //System.out.println("Polygone : " + xPoints.length + " Color : " + borderColor + ", " + fillColor);
    }

    @Override
    public void move(int xMove, int yMove) {
        for (Point point : points) {
            point.setX(point.getX() + xMove);
            point.setY(point.getY() + yMove);
        }
    }

    @Override
    public void erase() {
        
    }

    @Override
    public boolean hit(Point p) {
        Path2D path = new Path2D.Double();
        path.moveTo(points.get(0).getX(), points.get(0).getY());
        for (Point point : points) {
            path.lineTo(point.getX(), point.getY());
        }
        path.closePath();
        Point2D testPoint = new Point2D.Double(p.getX(), p.getY());
        return path.contains(testPoint);
    }

    @Override
    public boolean select(Graphics gr, Point p) {
        var g2d = (Graphics2D) gr;
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for(int i = 0; i < xPoints.length; i++)
        {
            xPoints[i] = points.get(i).getX();
            yPoints[i] = points.get(i).getY();
        }
        if(hit(p))
        {
            g2d.setColor(Color.cyan);
            g2d.fillPolygon(xPoints, yPoints, xPoints.length);
            return true;
        }
        return false;
    }

    @Override
    public Shape copy() {
        var tpoints = new ArrayList<Point>();
        for (Point point : points) {
            tpoints.add(Point.New(point.getX(), point.getY()));
        }
        return new Polygone(tpoints, borderColor, fillColor, isFill, isBorder);
    }

    @Override
    public void zoomIn(double factor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
