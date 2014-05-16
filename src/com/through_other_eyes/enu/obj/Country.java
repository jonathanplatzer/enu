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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author jplatzer
 * @date 10.05.2014
 */
public class Country extends GameComponent {

    private String name;
    private double population;
    private double gdp;
    private boolean euMember;
    private BufferedImage image;
    
    public Country(String inputData) throws IOException {
        this.name = inputData.split(";")[0];
        this.population = Double.parseDouble(inputData.split(";")[1]);
        this.gdp = Double.parseDouble(inputData.split(";")[2]);
        this.euMember = Boolean.parseBoolean(inputData.split(";")[3]);
        this.image = ImageIO.read(new File(inputData.split(";")[4]));
    }

    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(image, 0, 0, null);
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

    public boolean isEuMember() {
        return euMember;
    }

    public void setEuMember(boolean euMember) {
        this.euMember = euMember;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + name + ", population=" + population + ", gdp=" + gdp + '}';
    }

}