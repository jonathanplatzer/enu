/* Europa NON Universalis - A dogma 2001 game
 * Copyright (C) 2014 through.other.eyes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.ButtonGroup;
import com.through_other_eyes.enu.obj.base.Resource;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mwahlhuetter
 */
public class InstitutionMenu extends UIElement {

    private ArrayList<UIElement> uiElements = new ArrayList<>();
    private ButtonGroup buttonGroup;

    public InstitutionMenu(BufferedImage backgroundImage, GameCore.Align align, int offset, int y) throws IOException {
        super(backgroundImage, align, offset, y);
        this.buttonGroup = new ButtonGroup();
        CentralBankButton cbb = new CentralBankButton(Resource.CENTRALBANK, Resource.CENTRALBANK_HOVER, Resource.CENTRALBANK_TOGGLE, GameCore.Align.CENTER, -40, 7);
        CourtHouseButton chb = new CourtHouseButton(Resource.COURTHOUSE, Resource.COURTHOUSE_HOVER, Resource.COURTHOUSE_TOGGLE, GameCore.Align.CENTER, 40, 7);

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
        for (UIElement uiElement : uiElements) {
            if (uiElement.isVisible()) {
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
