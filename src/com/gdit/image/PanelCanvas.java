/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdit.image;

import com.asprise.util.tiff.TIFFReader;

/**
 *
 * @author bahy
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bahy
 */
public class PanelCanvas extends JPanel {

    private double translateX;
    private double translateY;
    private double scale = 0.7;
    private Image  img;
    private static PanelCanvas canvas;

    public void addImage(Image img) {
        this.img = img;
        canvas = this;
        TranslateHandler translater = new TranslateHandler();
        canvas.addMouseListener(translater);
        canvas.addMouseMotionListener(translater);
        canvas.addMouseWheelListener(new ScaleHandler());
    }

    @Override
    public void paintComponent(Graphics g) {

        AffineTransform tx = new AffineTransform();
        tx.translate(translateX, translateY);
        tx.scale(scale, scale);
        Graphics2D ourGraphics = (Graphics2D) g;
        ourGraphics.setColor(Color.WHITE);
        ourGraphics.fillRect(0, 0, getWidth(), getHeight());
        ourGraphics.setTransform(tx);
        ourGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ourGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        ourGraphics.setColor(Color.BLACK);
        //	ourGraphics.drawRect(50, 50, 50, 50);
        // 	ourGraphics.fillOval(100, 100, 100, 100);
        //	ourGraphics.drawString("Test Affine Transform", 50, 30);

        //     ourGraphics.rotate(angle);

            ourGraphics.drawImage(img , tx, this);

    }

    private static class TranslateHandler implements MouseListener,
            MouseMotionListener {

        private int lastOffsetX;
        private int lastOffsetY;

        public void mousePressed(MouseEvent e) {
            // capture starting point
            lastOffsetX = e.getX();
            lastOffsetY = e.getY();
        }

        public void mouseDragged(MouseEvent e) {

            // new x and y are defined by current mouse location subtracted
            // by previously processed mouse location
            int newX = e.getX() - lastOffsetX;
            int newY = e.getY() - lastOffsetY;

            // increment last offset to last processed by drag event.
            lastOffsetX += newX;
            lastOffsetY += newY;

            // update the canvas locations
            canvas.translateX += newX;
            canvas.translateY += newY;

            // schedule a repaint.
            canvas.repaint();

        }

        public void zoomin(){
            canvas.scale += (.01 );
                // don't cross negative threshold.
                // also, setting scale to 0 has bad effects
                canvas.scale = Math.max(0.00001, canvas.scale);
                canvas.repaint();
        }

        public void zoomout(){
            canvas.scale -= (.01 );
                // don't cross negative threshold.
                // also, setting scale to 0 has bad effects
                canvas.scale = Math.max(0.00001, canvas.scale);
                canvas.repaint();
        }

        public void mouseClicked(MouseEvent e) {
            {

                 zoomin();
            }
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }

    private static class ScaleHandler implements MouseWheelListener {

        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {

                // make it a reasonable amount of zoom
                // .1 gives a nice slow transition
                canvas.scale += (.1 * e.getWheelRotation());

                // don't cross negative threshold.
                // also, setting scale to 0 has bad effects
                canvas.scale = Math.max(0.00001, canvas.scale);
                canvas.repaint();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Image img = null;
        try {

          img = ImageIO.read(new File("c:/.capture/141/208690/page1.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(PanelCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        PanelCanvas cv = new PanelCanvas();

        cv.addImage(img);

        frame.setLayout(new BorderLayout());


        frame.getContentPane().add(cv, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
