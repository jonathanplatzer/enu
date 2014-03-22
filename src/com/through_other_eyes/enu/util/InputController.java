/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.util;

import com.through_other_eyes.enu.core.GameCore;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * @author mwahlhuetter
 * @date 22.03.2014
 */
public class InputController implements KeyListener{

    
    private Object source;
    
    
    public InputController(Object source) {
        this.source = source;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if(source instanceof GameCore)
            {
                ((GameCore)source).shutdown();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode() + " released");
    }
    
}
