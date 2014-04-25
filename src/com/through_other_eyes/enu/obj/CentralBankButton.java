/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.obj.base.ButtonGroup;
import com.through_other_eyes.enu.obj.base.ToggleButton;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author mwahlhuetter
 */
public class CentralBankButton extends ToggleButton{

    public CentralBankButton(Point position, BufferedImage elementImage, BufferedImage elementImageToggle) {
        super(position, elementImage, elementImageToggle);
    }

    @Override
    public void clicked() {
        super.clicked();
        System.out.println("THIS. IS. ZENTRAAAAAAAAAALBAAAAANK");
    }

    @Override
    public void hoverElement() {
    }

    @Override
    public void leaveElement() {
    }
}
