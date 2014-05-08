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
import com.through_other_eyes.enu.obj.base.Button;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mwahlhuetter
 * @date 05.04.2014
 */
public class ExitButton extends Button{
    
    public ExitButton(Point position, BufferedImage elementImage) throws IOException {
        super(position, elementImage);
    }

    public ExitButton(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
    }

    @Override
    public void clicked() {
        GameCore.state = GameCore.State.SHUTDOWN;
    }

    @Override
    public void hoverElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leaveElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
