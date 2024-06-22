/*
 * Mahdi Salimkhani

 */
package com.salimkhani.javapaint;

import com.salimkhani.javapaint.application.*;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author mahdi
 */
public class MainForm extends javax.swing.JFrame {
    private boolean isEntered = false;
    private Point p1, p2, p3;
    private ActionTypes actionType;
    private ShapeTypes curShape;
    private Color curBorColor = Color.black;
    private Color curFillColor = Color.white;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        area = new PaintingArea(pnlPaint.getGraphics(), pnlPaint.getHeight(), pnlPaint.getWidth());
        actionType = ActionTypes.Draw;
        p1 = p2 = p3 = null;
        curShape = null;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnLine = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnErase = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        fillCheck = new javax.swing.JCheckBox();
        borderCheck = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnFillColorChoose = new javax.swing.JButton();
        btnBorColorChoose = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        eraserSize = new javax.swing.JSlider();
        pnlPaint = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        lblPoint = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator3);

        btnLine.setText("Line");
        btnLine.setFocusable(false);
        btnLine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLine);

        jButton2.setText("Rectangle");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("Circle");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        btnErase.setText("Eraser");
        btnErase.setFocusable(false);
        btnErase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnErase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEraseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnErase);
        jToolBar1.add(jSeparator2);

        fillCheck.setText("Have filled?");
        fillCheck.setFocusable(false);
        fillCheck.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fillCheck.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(fillCheck);

        borderCheck.setText("Have Border?");
        borderCheck.setFocusable(false);
        borderCheck.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borderCheck.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(borderCheck);
        jToolBar1.add(jSeparator4);

        btnFillColorChoose.setText("FillColor Chooser");
        btnFillColorChoose.setFocusable(false);
        btnFillColorChoose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFillColorChoose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFillColorChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFillColorChooseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFillColorChoose);

        btnBorColorChoose.setText("Border Color Chooser");
        btnBorColorChoose.setFocusable(false);
        btnBorColorChoose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorColorChoose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorColorChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorColorChooseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBorColorChoose);
        jToolBar1.add(jSeparator1);

        jLabel2.setText("Eraser Size :");
        jToolBar1.add(jLabel2);

        eraserSize.setMajorTickSpacing(10);
        eraserSize.setMaximum(50);
        eraserSize.setMinimum(1);
        eraserSize.setMinorTickSpacing(2);
        eraserSize.setPaintLabels(true);
        eraserSize.setPaintTicks(true);
        jToolBar1.add(eraserSize);

        pnlPaint.setBackground(new java.awt.Color(255, 255, 255));
        pnlPaint.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlPaintMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlPaintMouseMoved(evt);
            }
        });
        pnlPaint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPaintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPaintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPaintMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlPaintMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlPaintMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlPaintLayout = new javax.swing.GroupLayout(pnlPaint);
        pnlPaint.setLayout(pnlPaintLayout);
        pnlPaintLayout.setHorizontalGroup(
            pnlPaintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlPaintLayout.setVerticalGroup(
            pnlPaintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        jLabel1.setText(" Point :   ");
        jToolBar2.add(jLabel1);
        jToolBar2.add(lblPoint);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPaint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPaint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlPaintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaintMouseEntered
        isEntered = true;
    }//GEN-LAST:event_pnlPaintMouseEntered

    private void pnlPaintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaintMouseExited
        isEntered = false;
        lblPoint.setText("(" + "-" + ", " + "-" + ")");
    }//GEN-LAST:event_pnlPaintMouseExited

    private void pnlPaintMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaintMouseMoved
        if(isEntered)
        {
            lblPoint.setText("(" + evt.getX() + ", " + evt.getY() + ")");
        }
    }//GEN-LAST:event_pnlPaintMouseMoved

    private void btnLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineActionPerformed
        actionType = ActionTypes.Draw;
        curShape = ShapeTypes.Line;
    }//GEN-LAST:event_btnLineActionPerformed

    private void pnlPaintMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaintMousePressed
        if(actionType == ActionTypes.Draw)
        {
            p1 = new Point(evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_pnlPaintMousePressed

    private void pnlPaintMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaintMouseReleased
        p2 = new Point(evt.getX(), evt.getY());
        if(curShape != null && actionType == ActionTypes.Draw)
        {
            switch (curShape) {
                case ShapeTypes.Line -> {
                    Line l;
                    if(!(p1 == null || p2 == null))
                    {
                        l = new Line(p1, p2, curBorColor);
                        area.addShape(l);
                        l.draw(pnlPaint.getGraphics());
                    }
            }
                case ShapeTypes.Circle->{
                    Circle c;
                    if(!(p1 == null || p2 == null))
                    {
                        c = new Circle(p1,(int) p2.distance(p1), curBorColor, curFillColor, fillCheck.isSelected(), borderCheck.isSelected());
                        area.addShape(c);
                        c.draw(pnlPaint.getGraphics());
                    }
                }
                case ShapeTypes.Rectangle->{
                    Rectangle r;
                    if(!(p1 == null || p2 == null))
                    {
                        r = new Rectangle(p1, p2, curBorColor, curFillColor, fillCheck.isSelected(), borderCheck.isSelected());
                        area.addShape(r);
                        r.draw(pnlPaint.getGraphics());
                    }
                }
                default -> System.out.println("Error");
            }
        }
        p1 = p2 = p3 = null;
        
    }//GEN-LAST:event_pnlPaintMouseReleased

    private void btnEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEraseActionPerformed
        actionType = ActionTypes.Erase;
    }//GEN-LAST:event_btnEraseActionPerformed

    private void pnlPaintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaintMouseClicked
        
    }//GEN-LAST:event_pnlPaintMouseClicked

    private void pnlPaintMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaintMouseDragged
        //System.out.println("(" + evt.getX() + ", " + evt.getY() + ")");
        if(actionType == ActionTypes.Erase)
        {
            var p = new Point(evt.getX(), evt.getY());
            var r = eraserSize.getValue();
            var c = new Circle(p, r, curBorColor, Color.WHITE, true, false);
            c.draw(pnlPaint.getGraphics());
            
        }
    }//GEN-LAST:event_pnlPaintMouseDragged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        actionType = ActionTypes.Draw;
        curShape = ShapeTypes.Circle;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnFillColorChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFillColorChooseActionPerformed
        Color color = JColorChooser.showDialog(this, "Select Fill Color", curFillColor);
        btnFillColorChoose.setBackground(color);
        curFillColor = color;
    }//GEN-LAST:event_btnFillColorChooseActionPerformed

    private void btnBorColorChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorColorChooseActionPerformed
        Color color = JColorChooser.showDialog(this, "Select Fill Color", curBorColor);
        btnBorColorChoose.setBackground(color);
        curBorColor = color;
    }//GEN-LAST:event_btnBorColorChooseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        curShape = ShapeTypes.Rectangle;
        actionType = ActionTypes.Draw;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        pnlPaint.repaint();
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox borderCheck;
    private javax.swing.JButton btnBorColorChoose;
    private javax.swing.JButton btnErase;
    private javax.swing.JButton btnFillColorChoose;
    private javax.swing.JButton btnLine;
    private javax.swing.JSlider eraserSize;
    private javax.swing.JCheckBox fillCheck;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JPanel pnlPaint;
    // End of variables declaration//GEN-END:variables
    private PaintingArea area;
}
