/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.core;

import com.through_other_eyes.enu.obj.SplashScreen;
import com.through_other_eyes.enu.obj.base.GameObject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class GamePanel extends JPanel {

    private ArrayList<GameObject> renderObjects;

    public GamePanel(int width, int height, ArrayList<GameObject> renderObjects) {
        this.setPreferredSize(new Dimension(width, height));
        this.renderObjects = renderObjects;
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
            case SPLASHSCREEN:
                for (GameObject gameObject : renderObjects) {
                    if (gameObject instanceof SplashScreen) {
                        gameObject.drawObject(g2);
                    }
                }
                break;

            case MAINMENU:
                break;
        }

        if (GameCore.debugMode) {
            renderDebugInformation(g2);
        }
        // WRITE SOME GRPHICS STUFF ...
    }

    private void renderDebugInformation(Graphics2D g2) {

        g2.setColor(new Color(0, 186, 255));
        g2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        g2.drawString("Europa NON Universalis -- DEBUG MODE --", 2, 12);
        g2.drawString("---------------------------------------", 2, 20);
        g2.drawString("GAMESTATE: " + GameCore.state, 2, 30);
        g2.drawString("FPS: " + Long.toString(GameCore.fps), 2, 42);
        g2.drawString("DT: " + GameCore.dt, 2, 54);
        g2.drawString(String.format("TOTAL MEMORY: %dMB", Runtime.getRuntime().totalMemory() / 1024 / 1024), 2, 66);
        g2.drawString(String.format("USED MEMORY: %dMB", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024), 2, 78);
        g2.drawString(time(), 2, 90);
    }

    private String time() {
        long timeInMilliSeconds = System.currentTimeMillis() - GameCore.startTime;
        long seconds = timeInMilliSeconds / 1000 % 60;
        long minutes = timeInMilliSeconds / 1000 /60;
        long hours = minutes / 60;
        long days = hours / 24;
        return String.format("TIME RUNNING: %02d:%02d:%02d:%03d", hours,minutes,seconds, timeInMilliSeconds % 1000);
    }
}
