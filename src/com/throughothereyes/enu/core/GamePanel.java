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
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Jonathan Platzer
 * @date 22.03.2014
 */
public class GamePanel extends JPanel {

    private float ratio;
    
    public GamePanel(int width, int height)
    {
        this.setSize(width, height);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        RenderingHints rh
                       = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);
        
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.gray);
        g2.setBackground(Color.BLACK);
        System.out.println(this.getSize());
        
        g2.fillRect(0, 0, 320, 240);
        g2.fillRect(320, 240, 320, 240);
//        g2.fillRect((int) Math.round(0*ratio), (int) Math.round(0*ratio), (int) Math.round(320*ratio), (int) Math.round(240*ratio));
//        
//        g2.fillRect((int) Math.round(320*ratio), (int) Math.round(240*ratio), (int) Math.round(320*ratio), (int) Math.round(240*ratio));

        
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("com.throughothereyes.enu.core" + File.separator + "fuck.jpg"));
//        } catch (IOException e) {
//            System.out.println("file not found");
//        }
//        
//        g2.drawImage(img, 0, 0, null);
        
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
    }
}
