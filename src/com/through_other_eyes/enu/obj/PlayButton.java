/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.Button;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mwahlhuetter
 * @date 03.04.2014
 */
public class PlayButton extends Button {

    public PlayButton(Point position, Dimension dimension, BufferedImage elementImage, String action) {
        super(position, dimension, elementImage, action);
    }

    public PlayButton(Dimension dimension, BufferedImage elementImage, String action, GameCore.Align align, int offset, int y) {
        super(dimension, elementImage, action, align, offset, y);
    }

    @Override
    public void clicked() {
        System.out.println("CLICKED:PLAY");
    }

    @Override
    public void move(float delta) {
        super.move(delta);
//        int animSpeed = 100;
//        int dx = (int) (animSpeed*delta);
//        System.out.println(dx + " " + delta);
//        System.out.println(getPosition());
//        setPosition(new Point((int) (getPosition().x + dx), getPosition().y));
    }
    
    private boolean hoverAnimation = false;
    
    @Override
    public void hover() {
        
        if (!hoverAnimation && isMouseHoverPossible()) {
            hoverAnimation = true;
            Thread animation = new Thread() {
                @Override
                public void run() {
                    for(int i = 0; i < 5; i++)
                    {
                        setPosition(new Point(getPosition().x-1, getPosition().y-1));
                        setDimension(new Dimension(getDimension().width+2, getDimension().height+2));
                        System.out.println(getPosition());
                        System.out.println(getDimension());
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PlayButton.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    for(int i = 0; i < 5; i++)
                    {
                        setPosition(new Point(getPosition().x+1, getPosition().y+1));
                        setDimension(new Dimension(getDimension().width-2, getDimension().height-2));
                        System.out.println(getPosition());
                        System.out.println(getDimension());
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PlayButton.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    hoverAnimation = false;
                }
            };
            animation.start();
        }
    }

    @Override
    public void drawObject(Graphics2D g2) {
        super.drawObject(g2);
    }

    @Override
    public void update() {
        super.update();
    }
}
