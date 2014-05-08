/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj.base;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.core.GameCore.UIElementState;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * @author mwahlhuetter
 * @date 24.03.2014
 */
public abstract class UIElement extends GameComponent {
    
    private boolean mouseHoverPossible;
    private BufferedImage elementImage;
    private BufferedImage hoverImage;
    private GameCore.Align align;
    private int offset;
    
    public UIElement(Point position, BufferedImage elementImage) {
        super(position, new Dimension(elementImage.getWidth(), elementImage.getHeight()));
        mouseHoverPossible = true;
        this.align = null;
        this.offset = 0;
        this.elementImage = elementImage;
    }

    public UIElement(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(new Point((GameCore.WIDTH/2)-(elementImage.getWidth()/2)+offset, y), new Dimension(elementImage.getWidth(), elementImage.getHeight()));
        mouseHoverPossible = true;
        this.elementImage = elementImage;
        this.align = align;
        this.offset = offset;
        calculatePosition();
    }
    
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
    
    public abstract void clicked();
    
    public abstract void hoverElement();

    public abstract void leaveElement();
    
    public boolean isMouseHoverPossible() {
        return mouseHoverPossible;
    }

    public void setMouseHoverPossible(boolean mouseHover) {
        this.mouseHoverPossible = mouseHover;
    }

    public BufferedImage getElementImage() {
        return elementImage;
    }

    public BufferedImage getHoverImage() {
        return hoverImage;
    }

    public void setHoverImage(BufferedImage hoverImage) {
        this.hoverImage = hoverImage;
    }
}
