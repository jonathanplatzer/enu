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
import com.through_other_eyes.enu.obj.base.ToggleButton;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mwahlhuetter <m.wahl1996 at gmail.com>
 */
public class CourtHouseButton extends ToggleButton{

    public CourtHouseButton(Point position, String elementImage, String hoverImage, String toggleImage) throws IOException {
        super(position, elementImage, hoverImage, toggleImage);
    }

    public CourtHouseButton(String elementImage, String hoverImage, String toggleImage, GameCore.Align align, int offset, int y) throws IOException {
        super(elementImage, hoverImage, toggleImage, align, offset, y);
    }
    
    @Override
    public void leaveElement() {
        setState(GameCore.UIElementState.DEFAULT);
    }
}
