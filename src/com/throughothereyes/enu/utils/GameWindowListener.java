/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.throughothereyes.enu.utils;

import com.throughothereyes.enu.core.GameMain;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author mwahlhuetter
 * @date 22.03.2014
 */
public class GameWindowListener implements WindowListener{

    private Object source;
    
    public GameWindowListener(Object source) {
        this.source = source;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(source instanceof GameMain)
        {
            ((GameMain)source).shutdown();
        }
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
