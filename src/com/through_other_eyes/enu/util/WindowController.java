/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.util;

import com.through_other_eyes.enu.core.GameCore;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author mwahlhuetter
 * @date 22.03.2014
 */
public class WindowController implements WindowListener{
    
    public WindowController() {
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        GameCore.state = GameCore.State.SHUTDOWN;
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
