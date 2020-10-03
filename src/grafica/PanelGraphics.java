/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class PanelGraphics extends javax.swing.JPanel {

    private Graphics g;
    private int cx;
    private int cy;
    private int fx;
    private int fy;
    private int scale;

    private int area_1;
    private int area_2;
    private boolean areasSpecific;

    private int area;
    private boolean areaSpecific;

    private boolean showGrid;
    private boolean axes;

    private int mousePositionX;
    private int mousePositionY;
    private boolean mouseDragged;
    private boolean dragged;

    private boolean started;
    
    private ArrayList<ArrayList<PointsXY>> functions;

    public PanelGraphics() {
        initComponents();
        this.scale = 50;
        this.areasSpecific = false;
        this.areaSpecific = false;
        this.showGrid = true;
        this.axes = true;
        this.mouseDragged = false;
        this.started = false;
        this.dragged = true;
        
        this.functions = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.g = g;
        this.fx = this.getWidth();
        this.fy = this.getHeight();
        //No se arrastra el mouse
        if (this.mouseDragged == false) {
            if (this.areaSpecific || this.areasSpecific) {
                if (this.started == false) {
                    this.initViews();
                }
            } else {
                this.cx = this.getWidth() / 2;
                this.cy = this.getHeight() / 2;
            }
        }
        this.paintComponents();
    }

    private void initViews() {
        if (this.areaSpecific) {
            this.viewArea();
        }
        if (this.areasSpecific) {
            this.viewAreas();
        }
    }

    private void paintComponents() {
        this.scalePoints();
        this.lineX();
        this.lineY();

        this.panelControls.repaint();
        
        if(this.functions.isEmpty() == false){
            this.paintFunctions();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelControls = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        zoomPlus1 = new javax.swing.JButton();
        zoomRest = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        panelControls.setBackground(new java.awt.Color(255, 255, 255));
        panelControls.setLayout(new java.awt.GridLayout(3, 1));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        btnReset.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnReset.setBorderPainted(false);
        btnReset.setContentAreaFilled(false);
        btnReset.setFocusPainted(false);
        btnReset.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset_clic.png"))); // NOI18N
        btnReset.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset_sobre.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelControls.add(btnReset);

        zoomPlus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/zoom+.png"))); // NOI18N
        zoomPlus1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        zoomPlus1.setBorderPainted(false);
        zoomPlus1.setContentAreaFilled(false);
        zoomPlus1.setFocusPainted(false);
        zoomPlus1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/zoom+_clic.png"))); // NOI18N
        zoomPlus1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/zoom+_sobre.png"))); // NOI18N
        zoomPlus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomPlus1ActionPerformed(evt);
            }
        });
        panelControls.add(zoomPlus1);

        zoomRest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/zoom-.png"))); // NOI18N
        zoomRest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        zoomRest.setBorderPainted(false);
        zoomRest.setContentAreaFilled(false);
        zoomRest.setFocusPainted(false);
        zoomRest.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/zoom-_clic.png"))); // NOI18N
        zoomRest.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/zoom-_sobre.png"))); // NOI18N
        zoomRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomRestActionPerformed(evt);
            }
        });
        panelControls.add(zoomRest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addComponent(panelControls, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(panelControls, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void zoomRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomRestActionPerformed
        this.scale -= 5;
        this.repaint();
    }//GEN-LAST:event_zoomRestActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.scale = 50;
        this.started = false;
        this.repaint();
    }//GEN-LAST:event_btnResetActionPerformed

    private void zoomPlus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomPlus1ActionPerformed
        this.scale += 5;
        this.repaint();
    }//GEN-LAST:event_zoomPlus1ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (this.dragged) {
            this.mouseDragged = true;
            this.cy = this.cy + (evt.getY() - this.mousePositionY);
            this.cx = this.cx + (evt.getX() - this.mousePositionX);
            this.repaint();
            this.mousePositionX = evt.getX();
            this.mousePositionY = evt.getY();
            this.started = true;
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.mousePositionX = evt.getX();
        this.mousePositionY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.mouseDragged = false;
    }//GEN-LAST:event_formMouseReleased

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized
    public void setViewArea(int area) {
        this.area = area;
        this.areaSpecific = true;
    }

    private void viewArea() {
        if (this.area == 1) {
            this.cx = this.getWidth() - 30;
            this.cy = this.getHeight() - 30;
        }
        if (this.area == 2) {
            this.cx = 30;
            this.cy = this.getHeight() - 30;
        }
        if (this.area == 3) {
            this.cx = 30;
            this.cy = 30;
        }
        if (this.area == 4) {
            this.cx = this.getWidth() - 30;
            this.cy = 30;
        }
        this.fx = this.getWidth();
        this.fy = this.getHeight();
    }

    public void setViewAreas(int area_1, int area_2) {
        this.area_1 = area_1;
        this.area_2 = area_2;
        this.areasSpecific = true;
    }

    private void viewAreas() {

        if (this.area_1 == 1 && this.area_2 == 2) {
            this.cx = this.getWidth() / 2;
            this.cy = this.getHeight() - 30;
        }
        if (this.area_1 == 2 && this.area_2 == 3) {
            this.cx = 30;
            this.cy = this.getHeight() / 2;
        }
        if (this.area_1 == 4 && this.area_2 == 3) {
            this.cx = this.getWidth() / 2;
            this.cy = 30;
        }
        if (this.area_1 == 1 && this.area_2 == 4) {
            this.cx = this.getWidth() - 30;
            this.cy = this.getHeight() / 2;
        }
        this.fx = this.getWidth();
        this.fy = this.getHeight();
    }

    private void pointCenter() {
        this.g.fillOval(this.cx - 2, this.cy - 2, 4, 4);
    }

    private void lineX() {
        if (this.axes == false) {
            this.g.setColor(new Color(197, 197, 197));
        } else {
            this.g.setColor(new Color(0, 0, 0));
        }
        this.g.drawLine(0, this.cy, this.fx, this.cy);
    }

    private void lineY() {
        if (this.axes == false) {
            this.g.setColor(new Color(197, 197, 197));
        } else {
            this.g.setColor(new Color(0, 0, 0));
        }
        this.g.drawLine(this.cx, 0, this.cx, this.fy);
    }

    private void scalePoints() {
        int con = 0;
        int div = 0;

        //area 1 Y
        for (int i = this.cx; i > 0; i--) {
            con++;
            if (con == this.scale) {
                div++;
                this.paintGrid(i, 0, i, this.fy);
                this.paintScaleNumber(("-" + div), i - 7, this.cy + 15);
                con = 0;
            }
        }
        //area 2 Y
        con = 0;
        div = 0;
        for (int i = this.cx; i < this.fx; i++) {
            con++;
            if (con == this.scale) {
                div++;
                this.paintGrid(i, 0, i, this.fy);
                this.paintScaleNumber(("" + div), i - 2, this.cy + 15);
                con = 0;
            }
        }
        //area 1 X
        con = 0;
        div = 0;
        for (int i = this.cy; i > 0; i--) {
            con++;
            if (con == this.scale) {
                div++;
                this.paintGrid(0, i, this.fx, i);
                this.paintScaleNumber(("" + div), this.cx - 25, i + 5);
                con = 0;
            }
        }
        //area 2 X
        con = 0;
        div = 0;
        for (int i = this.cy; i < this.fy; i++) {
            con++;
            if (con == this.scale) {
                div++;
                this.paintGrid(0, i, this.fx, i);
                this.paintScaleNumber(("-" + div), this.cx - 25, i + 5);
                con = 0;
            }
        }
    }

    private void paintGrid(int x1, int y1, int x2, int y2) {
        if (this.showGrid) {
            this.g.setColor(new Color(197, 197, 197));
            this.g.drawLine(x1, y1, x2, y2);
        }
    }

    private void paintScaleNumber(String number, int x, int y) {
        if (this.axes) {
            this.g.setColor(new Color(100, 100, 100));
            Font font = new Font("Calibri", Font.BOLD, 15);
            this.g.setFont(font);
            this.g.drawString(number, x, y);
        }
    }
    
    public boolean isShowGrid() {
        return showGrid;
    }

    public void setShowGrid(boolean showGrid) {
        this.showGrid = showGrid;
        this.repaint();
    }

    public boolean isAxes() {
        return axes;
    }

    public void setAxes(boolean axes) {
        this.axes = axes;
        this.repaint();
    }

    public boolean isDragged() {
        return dragged;
    }

    public void setDragged(boolean dragged) {
        this.dragged = dragged;
    }
    
    
    public void paintFunctions(){
        for (int i = 0; i < this.functions.size(); i++) {
            for (int j = 1; j < this.functions.get(i).size(); j++) {
                PointsXY objXY2 = this.functions.get(i).get(j);
                int px2 = this.cx + ((int) objXY2.getX() * this.scale);
                int py2 = this.cy - ((int) objXY2.getY() * this.scale);
                
                PointsXY objXY1 = this.functions.get(i).get(j-1);
                int px1 = this.cx + ((int) objXY1.getX() * this.scale);
                int py1 = this.cy - ((int) objXY1.getY() * this.scale);
                /*
                System.out.println("Centro");
                System.out.println("cx = "+cx);
                System.out.println("cy = "+cy);
                
                System.out.println("Normales");
                System.out.println("P1("+objXY1.getX()+","+objXY1.getY()+")");
                System.out.println("P2("+objXY2.getX()+","+objXY2.getY()+")");
                
                System.out.println("Convertido");
                System.out.println("P1("+px1+","+py1+")");
                System.out.println("P2("+px2+","+py2+")");
                */
                
                this.g.drawLine(px1, py1, px2, py2);
            }
        }
    }
    
    
    
    public void addFunction(ArrayList<PointsXY> listPoints){
        this.functions.add(listPoints);
    }

    public ArrayList<ArrayList<PointsXY>> getFunctions() {
        return functions;
    }
    public ArrayList<PointsXY> getFunctionIndex(int index){
        return this.functions.get(index);
    }
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel panelControls;
    private javax.swing.JButton zoomPlus1;
    private javax.swing.JButton zoomRest;
    // End of variables declaration//GEN-END:variables
}
