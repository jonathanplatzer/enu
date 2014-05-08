/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.core.GamePanel;
import com.through_other_eyes.enu.obj.base.ButtonGroup;
import com.through_other_eyes.enu.obj.base.ToggleButton;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author mwahlhuetter
 */
public class CentralBankButton extends ToggleButton {

    public CentralBankButton(Point position, BufferedImage elementImage, BufferedImage elementImageToggle) throws IOException {
        super(position, elementImage, elementImageToggle);
        setHoverImage(ImageIO.read(new File("res" + File.separator + "zentralbank_hovered.png")));
    }

    public CentralBankButton(BufferedImage elementImage, BufferedImage elementImageToggle, GameCore.Align align, int offset, int y) throws IOException {
        super(elementImage, elementImageToggle, align, offset, y);
        setHoverImage(ImageIO.read(new File("res" + File.separator + "zentralbank_hovered.png")));
    }

    @Override
    public void clicked() {
        GameCore.questionDialog.setVisible(true);
    }

    @Override
    public void hoverElement() {
        if (isMouseHoverPossible()) {
            setState(GameCore.UIElementState.HOVER);
        }
    }

    @Override
    public void leaveElement() {
        setState(GameCore.UIElementState.DEFAULT);
    }
}
