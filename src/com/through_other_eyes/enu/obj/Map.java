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
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.Resource;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 * @author mwahlhuetter
 * @date 04.04.2014
 */
public class Map extends GameComponent {

    private HashMap<String, Country> countries = new HashMap<String, Country>();
    private ArrayList<UIElement> uiElements = new ArrayList<>();
    private Image background;
    private Font font = GameCore.font.deriveFont(12f);
    private double population;

    public Map() throws IOException {
        loadMap();
        InstitutionMenu instMenu = new InstitutionMenu(ImageIO.read(Resource.INSTITUION_MENU), GameCore.Align.CENTER, 0, 0);
        uiElements.add(instMenu);
    }

    private void loadMap() throws IOException {
        background = Toolkit.getDefaultToolkit().createImage(Resource.MAP_WATER.getPath());
        
        FileReader fr = new FileReader(Resource.MAP_DATA);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        
        while ((line = br.readLine()) != null) {
            countries.put(line.split(";")[0],new Country(line));
        }
    }

    @Override
    public void update() {
        population = 0;
        for (Country country : countries.values()) {
            if(country.isEuMember())
            population += country.getPopulation();
        }
    }

    int x, y;

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(background, 0, 0, null);
        for (Country country : countries.values()) {
            if(country.isEuMember()) {
                country.drawObject(g2);
            }
        }
        for (UIElement uilement : uiElements) {
            if (uilement.isVisible()) {
                uilement.drawObject(g2);
            }
        }
        g2.setFont(font);
        g2.setColor(Color.RED);
        g2.drawString(String.format("Population: %.0f mil.", population), 40, 40);
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
