/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.Button;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mwahlhuetter
 * @date 05.04.2014
 */
public class ExitButton extends Button{
    
    public ExitButton(Point position, BufferedImage elementImage) throws IOException {
        super(position, elementImage);
    }

    public ExitButton(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
    }

    @Override
    public void clicked() {
        GameCore.state = GameCore.State.SHUTDOWN;
    }

    @Override
    public void hoverElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leaveElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
