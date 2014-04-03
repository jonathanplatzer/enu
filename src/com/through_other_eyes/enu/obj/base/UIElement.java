/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj.base;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.util.MouseInputController;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 * @author mwahlhuetter
 * @date 24.03.2014
 */
public abstract class UIElement extends GameComponent {
    
    public UIElement(Point position, Dimension dimension) {
        super(position, dimension);
    }
    
    public abstract void clicked();
    
//    @Override
//    public void paint(Graphics g)
//    {
//        super.paint(g);
//    }
}
