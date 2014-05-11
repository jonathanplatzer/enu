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

import com.through_other_eyes.enu.obj.base.GameComponent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @author jplatzer
 * @date 10.05.2014
 */
public class Country extends GameComponent {
    private String name;
    private double population;
    private double gdp;
    private BufferedImage image;

    public Country(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }
    
    public Country(String name, double population, int gdp, BufferedImage image) {
        this.name = name;
        this.population = population;
        this.gdp = gdp;
        this.image = image;
    }
    
    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(image, this.getPosition().x, this.getPosition().y, null);
    }

    @Override
    public void move(float delta) {
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }
    
    
}
