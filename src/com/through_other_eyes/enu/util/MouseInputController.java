/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.util;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JOptionPane;


/**
 * @author mwahlhuetter
 * @date 23.03.2014
 */
public class MouseInputController implements MouseWheelListener, MouseListener{

    //TO DO
    // make interface clickable, check if mouseevent source is game object + clickable, then call click, interact etc method of the object licked
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(GameCore.state == GameCore.State.MAINMENU)
        {
            System.out.println(GameCore.uiElements.size());
            Point mousePosition = e.getPoint();
            for(UIElement uielement : GameCore.uiElements)
            {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();

    //            System.out.println("x=" + uiElementPosition.x + "y=" + uiElementPosition.y);
    //            System.out.println("x=" + mousePosition.x + "y=" + mousePosition.y);
    //            System.out.println("x=" + (uiElementPosition.x + uiElementDimension.width) + "y=" + (uiElementPosition.y + uiElementDimension.height));

                if(mousePosition.x >= uiElementPosition.x && mousePosition.y >= uiElementPosition.y && mousePosition.x <= uiElementPosition.x + uiElementDimension.width && mousePosition.y <= uiElementPosition.y + uiElementDimension.height)
                {
                    uielement.clicked();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
