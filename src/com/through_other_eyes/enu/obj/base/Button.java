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

    private BufferedImage elementImage;
    private GameCore.Align align;
    private int offset;
    
    public Button(Point position, BufferedImage elementImage) {
        super(position, new Dimension(elementImage.getWidth(), elementImage.getHeight()));
        this.elementImage = elementImage;
        this.align = null;
        this.offset = 0;
    }
    
    public Button(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(new Point((GameCore.WIDTH/2)-(elementImage.getWidth()/2)+offset, y), new Dimension(elementImage.getWidth(), elementImage.getHeight()));
        this.elementImage = elementImage;
        this.align = align;
        this.offset = offset;
        calculatePosition();
    }

    //konstrukt
    //text + bild
    //text + hintergrundfarbe
    
    
    private void calculatePosition()
    {
        switch(align)
        {
            case LEFT:
                setPosition(new Point(0+offset,getPosition().y));
                break;
            case CENTER:
                setPosition(new Point((GameCore.WIDTH/2)-(getDimension().width/2)+offset,getPosition().y));
                break;
            case RIGHT:
                setPosition(new Point(GameCore.WIDTH-getDimension().width+offset,getPosition().y));
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(elementImage, getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
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

    public BufferedImage getElementImage() {
        return elementImage;
    }
}
