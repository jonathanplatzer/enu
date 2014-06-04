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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jplatzer
 */
public class StatisticsBar extends UIElement {

    private final Font font = GameCore.font.deriveFont(12f);

    public StatisticsBar(Point position, File elementImage, HashMap<String, Country> countries) throws IOException {
        super(position, ImageIO.read(elementImage));
        GameCore.statistics = new Statistics(countries);
    }

    @Override
    public void clicked() {
    }

    @Override
    public void hoverElement() {
    }

    @Override
    public void leaveElement() {
    }

    @Override
    public void update() {
        try {
            GameCore.statistics.calculate();
        } catch (InterruptedException ex) {
            Logger.getLogger(StatisticsBar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(getElementImage(), 0, 460, null);
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMM");
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

        g2.setFont(font);
        g2.setColor(Color.WHITE);
        g2.drawString(String.format("Population: %.03f mil.", GameCore.statistics.getPopulation()), 20, 474);
        g2.drawString(String.format("GDP: %.03f mil.", GameCore.statistics.getGDP()), 150, 474);
        g2.drawString(String.format("GDP per Capita: %.03f k", GameCore.statistics.getGDPpC()), 280, 474);
        g2.drawString(String.format("%s", sdfDay.format(GameCore.statistics.getGameTime().getTime())), 571, 474);
        g2.drawString(String.format(". %s", sdfMonth.format(GameCore.statistics.getGameTime().getTime())), 583, 474);
        g2.drawString(String.format("%s", sdfYear.format(GameCore.statistics.getGameTime().getTime())), 610, 474);
    }

    @Override
    public void move(float delta) {
    }

}
