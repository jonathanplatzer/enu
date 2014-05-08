/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author mwahlhuetter
 * @date 04.04.2014
 */
public class Map extends GameComponent {

    private ArrayList<GameComponent> mapLayer = new ArrayList<>();
    private ArrayList<UIElement> uiElements = new ArrayList<>();
    
    public Map() throws IOException {
        InstitutionMenu instMenu = new InstitutionMenu(ImageIO.read(new File("res" + File.separator + "institutionmenu.png")), GameCore.Align.CENTER, 0, 0);
        uiElements.add(instMenu);
    }
    
    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        for (UIElement uilement : uiElements) {
            uilement.drawObject(g2);
        }
    }

    @Override
    public void move(float delta) {
    }

    /**
     * 
     * @return 
     */
    public InstitutionMenu getInstMenu() {
        for (UIElement uilement : uiElements) {
            if(uilement instanceof InstitutionMenu)
            {
                return (InstitutionMenu) uilement;
            }
        }
        return null;
    }

    public ArrayList<UIElement> getUiElements() {
        return uiElements;
    }
}
