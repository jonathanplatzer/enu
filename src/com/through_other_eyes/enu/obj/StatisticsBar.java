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
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author jplatzer
 */
public class StatisticsBar extends UIElement {
    
    private final Font font = GameCore.font.deriveFont(12f);
    private final Statistics statistics;
    
    public StatisticsBar(Point position, File elementImage, HashMap<String, Country> countries) throws IOException {
        super(position, ImageIO.read(elementImage));
        statistics = new Statistics(countries);
    }

    @Override
    public void clicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hoverElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leaveElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        statistics.calculate();
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(getElementImage(), 0, 460, null);
        
        g2.setFont(font);
        g2.setColor(Color.RED);
        g2.drawString(String.format("Population: %.03f mil.", statistics.getPopulation()), 20, 474);
        g2.drawString(String.format("GDP: %.03f mil.", statistics.getGDP()), 200, 474);
        g2.drawString(String.format("GDP per Capita: %.03f k", statistics.getGDPpC()), 400, 474);
    
    }

    @Override
    public void move(float delta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
