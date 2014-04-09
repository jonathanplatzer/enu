/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj.base;

import java.awt.Dimension;
import java.awt.Point;

/**
 * @author mwahlhuetter
 * @date 24.03.2014
 */
public abstract class UIElement extends GameComponent {
    
    private boolean mouseHoverPossible;
    
    public UIElement(Point position, Dimension dimension) {
        super(position, dimension);
        mouseHoverPossible = true;
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
}
