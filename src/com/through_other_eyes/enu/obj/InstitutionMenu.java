/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.ButtonGroup;
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mwahlhuetter
 */
public class InstitutionMenu extends UIElement{
    
    private ArrayList<UIElement> uiElements = new ArrayList<>();
    private ButtonGroup buttonGroup;
    
    public InstitutionMenu(BufferedImage backgroundImage, GameCore.Align align, int offset, int y) throws IOException {
        super(backgroundImage, align, offset, y);
        this.buttonGroup = new ButtonGroup();
        CentralBankButton cbb = new CentralBankButton(ImageIO.read(new File("res" + File.separator + "zentralbank.png")), ImageIO.read(new File("res" + File.separator + "zentralbank_toggled.png")), GameCore.Align.CENTER, -40, 7);
        CourtHouseButton chb = new CourtHouseButton(ImageIO.read(new File("res" + File.separator + "gerichtshof.png")), ImageIO.read(new File("res" + File.separator + "gerichtshof_toggled.png")), GameCore.Align.CENTER, 40, 7);
        
        uiElements.add(cbb);
        uiElements.add(chb);
        //uiElements.add(cbb4);
        
        buttonGroup.addButton(cbb);
        buttonGroup.addButton(chb);
        //buttonGroup.addButton(cbb4);
    }

    
    
    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(getElementImage(), getPosition().x, getPosition().y, null);
        for(UIElement uiElement : uiElements)
        {
            if(uiElement.isVisible())
            {
                uiElement.drawObject(g2);
            }
        }
    }

    @Override
    public void move(float delta) {
    }

    public ArrayList<UIElement> getUiElements() {
        return uiElements;
    }

    @Override
    public void clicked() {
        System.out.println("INSTMENU");
    }

    @Override
    public void hoverElement() {
    }

    @Override
    public void leaveElement() {
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }
}
