/*
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
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.Resource;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author jplatzer
 */
public class GameScreen extends GameComponent {

    private Map map;
    private ArrayList<UIElement> uiElements = new ArrayList<>();

    public GameScreen() throws IOException {
        map = new Map();
        InstitutionMenu instMenu = new InstitutionMenu(ImageIO.read(Resource.INSTITUION_MENU), GameCore.Align.CENTER, 0, 0);
        StatisticsBar bar = new StatisticsBar(new Point(0, 0), Resource.STAISTICSBAR, map.getCountries());
        uiElements.add(instMenu);
        uiElements.add(bar);
    }

    @Override
    public void update() {
        map.update();
        for (UIElement uiElement : uiElements) {
            uiElement.update();
        }
    }

    @Override
    public void drawObject(Graphics2D g2
    ) {
        map.drawObject(g2);
        for (UIElement uilement : uiElements) {
            if (uilement.isVisible()) {
                uilement.drawObject(g2);
            }
        }
    }

    @Override
    public void move(float delta
    ) {
    }

    /**
     *
     * @return
     */
    public InstitutionMenu getInstMenu() {
        for (UIElement uilement : uiElements) {
            if (uilement instanceof InstitutionMenu) {
                return (InstitutionMenu) uilement;
            }
        }
        return null;
    }

    public ArrayList<UIElement> getUiElements() {
        return uiElements;
    }
}
