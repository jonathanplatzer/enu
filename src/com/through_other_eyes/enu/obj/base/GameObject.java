/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj.base;

import java.awt.Dimension;
import java.awt.Point;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public abstract class GameObject implements Drawable, Moveable{
    private Point position;
    private Dimension dimension;
    private boolean visible;
    
}
