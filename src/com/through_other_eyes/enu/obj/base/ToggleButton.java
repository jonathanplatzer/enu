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
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mwahlhuetter
 */
public abstract class ToggleButton extends Button {

    private BufferedImage toggleImage;
    private boolean toggled = false;
    private GameCore.UIElementState State = GameCore.UIElementState.DEFAULT;

    public ToggleButton(Point position, File elementImage, File hoverImage, File toggleImage) throws IOException {
        super(position, elementImage, hoverImage);
        this.toggleImage = ImageIO.read(toggleImage);
    }

    public ToggleButton(File elementImage, File hoverImage, File toggleImage, GameCore.Align align, int offset, int y) throws IOException {
        super(elementImage, hoverImage, align, offset, y);
        this.toggleImage = ImageIO.read(toggleImage);
    }

    @Override
    public void clicked() {
        toggled = !toggled;
    }

    @Override
    public void hoverElement() {
        if (isMouseHoverPossible()) {
            setState(GameCore.UIElementState.HOVER);
        }
    }

    @Override
    public abstract void leaveElement();

    @Override
    public void drawObject(Graphics2D g2) {
        if (toggled) {
            g2.drawImage(toggleImage, getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
        } else {
            switch (State) {
                case DEFAULT:
                    g2.drawImage(getElementImage(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
                    break;
                case HOVER:
                    g2.drawImage(getHoverImage(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
                    break;
            }
        }
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void setState(GameCore.UIElementState State) {
        this.State = State;
    }

    public boolean isToggled() {
        return toggled;
    }
}
