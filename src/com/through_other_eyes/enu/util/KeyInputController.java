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
public class KeyInputController implements KeyListener{
    
    public KeyInputController() {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            GameCore.state = GameCore.State.SHUTDOWN;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_F1)
        {
            GameCore.debugMode = !GameCore.debugMode;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode() + " released");
    }
    
}
