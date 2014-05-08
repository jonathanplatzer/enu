/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj.base;

import com.through_other_eyes.enu.core.GameCore;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * @author mwahlhuetter
 * @date 27.03.2014
 */
public abstract class Button extends UIElement {
    
    public Button(Point position, BufferedImage elementImage) {
        super(position, elementImage);
    }
    
    public Button(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
    }

    //konstrukt
    //text + bild
    //text + hintergrundfarbe

    @Override
    public void update() {

    }

    @Override
    public void drawObject(Graphics2D g2) {
        
        g2.drawImage(getElementImage(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
    }

    @Override
    public void move(float delta) {
        
    }

    @Override
    public abstract void clicked();

    @Override
    public abstract void hoverElement();

    @Override
    public abstract void leaveElement();
}
