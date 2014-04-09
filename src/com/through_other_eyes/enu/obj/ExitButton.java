/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.Button;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * @author mwahlhuetter
 * @date 05.04.2014
 */
public class ExitButton extends Button {

    public ExitButton(Point position, Dimension dimension, BufferedImage elementImage) {
        super(position, elementImage);
    }

    public ExitButton(Dimension dimension, BufferedImage elementImage, String action, GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
    }

    @Override
    public void clicked() {
        GameCore.state = GameCore.State.SHUTDOWN;
    }

    @Override
    public void hoverElement() {
    }

    @Override
    public void leaveElement() {
    }
}
