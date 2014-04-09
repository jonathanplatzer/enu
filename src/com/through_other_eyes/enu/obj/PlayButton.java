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

    public PlayButton(Point position, BufferedImage elementImage) {
        super(position, elementImage);
    }

    public PlayButton(BufferedImage elementImage,GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
    }

    @Override
    public void clicked() {
        GameCore.state = GameCore.State.PLAY;
    }

    @Override
    public void move(float delta) {
        super.move(delta);
        int animSpeed = 100;
        int dMove = (int) (animSpeed*delta);
        System.out.println(dMove + " " + delta);
        System.out.println(getPosition());
        setPosition(new Point((int) (getPosition().x), getPosition().y + dMove));
    }

    private boolean hoverAnimation = false;

    @Override
    public void hoverElement() {
        if (!hoverAnimation && isMouseHoverPossible()) {
            hoverAnimation = true;
            Thread animationThread = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 2; i++) {
                        setPosition(new Point(getPosition().x - 3, getPosition().y - 1));
                        setDimension(new Dimension(getDimension().width + 6, getDimension().height + 2));
//                        setPosition(new Point(getPosition().x, getPosition().y - 4)); FUN WITH PLAY BUTTON
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PlayButton.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    hoverAnimation = false;
                }
            };
            animationThread.start();
        }
    }

    @Override
    public void leaveElement() {
        Thread animationThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    setPosition(new Point(getPosition().x + 3, getPosition().y + 1));
                    setDimension(new Dimension(getDimension().width - 6, getDimension().height - 2));
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        animationThread.start();
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
