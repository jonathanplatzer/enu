/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj.base;

import com.through_other_eyes.enu.core.GameCore;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author mike7707
 */
public abstract class ToggleButton extends Button {

    private BufferedImage elementImageToggle;
    private boolean toggled = false;
    private GameCore.UIElementState State = GameCore.UIElementState.DEFAULT;

    public ToggleButton(Point position, BufferedImage elementImage, BufferedImage elementImageToggle) {
        super(position, elementImage);
        this.elementImageToggle = elementImageToggle;
    }

    public ToggleButton(BufferedImage elementImage, BufferedImage elementImageToggle, GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
        this.elementImageToggle = elementImageToggle;
    }

    @Override
    public void clicked() {
        toggled = !toggled;
    }

    @Override
    public abstract void hoverElement();

    @Override
    public abstract void leaveElement();

    @Override
    public void drawObject(Graphics2D g2) {
        if (toggled) {
            g2.drawImage(elementImageToggle, getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
        } else {
            switch (State) {
                case DEFAULT:
                    g2.drawImage(getElementImage(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
                    break;
                case HOVER:
                    g2.drawImage(getHoverImage(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
                    break;
            }
        }
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void setState(GameCore.UIElementState State) {
        this.State = State;
    }
}
