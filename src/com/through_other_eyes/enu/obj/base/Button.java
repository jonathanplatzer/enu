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

package com.through_other_eyes.enu.obj.base;

import com.through_other_eyes.enu.core.GameCore;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * @author mwahlhuetter
 * @date 27.03.2014
 */
public abstract class Button extends UIElement {
    
    public Button(Point position, BufferedImage elementImage) {
        super(position, elementImage);
    }
    
    public Button(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
    }

    //konstrukt
    //text + bild
    //text + hintergrundfarbe

    @Override
    public void update() {

    }

    @Override
    public void drawObject(Graphics2D g2) {
        
        g2.drawImage(getElementImage(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
    }

    @Override
    public void move(float delta) {
        
    }

    @Override
    public abstract void clicked();

    @Override
    public abstract void hoverElement();

    @Override
    public abstract void leaveElement();
}
