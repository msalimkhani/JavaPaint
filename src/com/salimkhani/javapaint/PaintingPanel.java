/*
 * Mahdi Salimkhani

 */
package com.salimkhani.javapaint;
import com.salimkhani.javapaint.application.PaintingArea;
import com.salimkhani.javapaint.application.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author mahdi
 */
public class PaintingPanel extends javax.swing.JPanel {
    private final PaintingArea pArea;
    private boolean isZoom = false;
    private double zoomFactor = 1;

    /**
     * Creates new form PaintingPanel
     */
    public PaintingPanel() {
        pArea = PaintingArea.New(getHeight(), getWidth());
        initComponents();
    }
    public void setZoomFactor(double factor){        
        if(factor<this.zoomFactor){
            this.zoomFactor=this.zoomFactor/1.1;
        }
        else{
            this.zoomFactor=factor;
        }
        this.isZoom=true;
    }
    public double getZoomFactor()
    {
        return zoomFactor;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var at = ((Graphics2D)g).getTransform();
        if(isZoom)
        {
            at.scale(zoomFactor,zoomFactor);
            isZoom=false;
            ((Graphics2D)g).transform(at);
        }
        pArea.reDrawAll(g);
    }
    public void drawComponent(Shape s)
    {
        pArea.addShape(s);
        repaint();
        //s.draw(getGraphics());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
