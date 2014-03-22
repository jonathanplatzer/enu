/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.throughothereyes.enu.core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Fidelity;
import javax.swing.JPanel;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class GamePanel extends JPanel {

    Image splash;
    
    public GamePanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        init();
    }

    private void init() {
        try {
            splash = ImageIO.read(new File("src" + File.separator + "com" + File.separator + "throughothereyes" + File.separator + "enu" + File.separator + "res" + File.separator + "toe_splash.png"));
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//
//        Graphics2D g2 = (Graphics2D) g;
//        RenderingHints rh
//                       = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
//                                            RenderingHints.VALUE_ANTIALIAS_ON);
//
//        rh.put(RenderingHints.KEY_RENDERING,
//               RenderingHints.VALUE_RENDER_QUALITY);
//
//        g2.setRenderingHints(rh);
//        g2.setStroke(new BasicStroke(1));
//        g2.setColor(Color.gray);
//        g2.setBackground(Color.BLACK);
//        
//        g2.fillRect(0, 0, 320, 240);
//        g2.fillRect(320, 240, 320, 240);
//        g2.fillRect((int) Math.round(0*ratio), (int) Math.round(0*ratio), (int) Math.round(320*ratio), (int) Math.round(240*ratio));
//        
//        g2.fillRect((int) Math.round(320*ratio), (int) Math.round(240*ratio), (int) Math.round(320*ratio), (int) Math.round(240*ratio));
//        try {
//            img = ImageIO.read(new File("src" + File.separator + "com" + File.separator + "throughothereyes" + File.separator + "enu" + File.separator + "res" + File.separator + "test3.gif"));
//        } catch (IOException e) {
//            System.out.println("file not found");
//        }
//        g2.drawImage(img, 0, 0, getWidth(), getHeight(), null);
//        Dimension size = getSize();
//        double w = size.getWidth();
//        double h = size.getHeight();
//
//        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
//        g2.setStroke(new BasicStroke(1));
//        g2.setColor(Color.gray);
//
//        for (double deg = 0; deg < 360; deg += 5) {
//            AffineTransform at
//                            = AffineTransform.getTranslateInstance(w / 2, h / 2);
//            at.rotate(Math.toRadians(deg));
//            g2.draw(at.createTransformedShape(e));
//        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch (GameCore.state) {
            case SPLASH:
                g2.drawImage(splash, 0, 0, getWidth(), getHeight(), null);
                break;
            case MAINMENU:

                break;
        }

        // WRITE SOME GRPHICS STUFF ...
    }
}
