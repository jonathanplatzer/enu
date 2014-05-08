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
import com.through_other_eyes.enu.core.GameCore.UIElementState;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * @author mwahlhuetter
 * @date 24.03.2014
 */
public abstract class UIElement extends GameComponent {

    private boolean mouseHoverPossible;
    private BufferedImage elementImage;
    private BufferedImage hoverImage;
    private GameCore.Align align;
    private int offset;

    public UIElement(Point position, BufferedImage elementImage) {
        super(position, new Dimension(elementImage.getWidth(), elementImage.getHeight()));
        mouseHoverPossible = true;
        this.align = null;
        this.offset = 0;
        this.elementImage = elementImage;
    }

    public UIElement(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(new Point((GameCore.WIDTH / 2) - (elementImage.getWidth() / 2) + offset, y), new Dimension(elementImage.getWidth(), elementImage.getHeight()));
        mouseHoverPossible = true;
        this.elementImage = elementImage;
        this.align = align;
        this.offset = offset;
        calculatePosition();
    }

    private void calculatePosition() {
        switch (align) {
            case LEFT:
                setPosition(new Point(0 + offset, getPosition().y));
                break;
            case CENTER:
                setPosition(new Point((GameCore.WIDTH / 2) - (getDimension().width / 2) + offset, getPosition().y));
                break;
            case RIGHT:
                setPosition(new Point(GameCore.WIDTH - getDimension().width + offset, getPosition().y));
                break;
        }
    }

    public abstract void clicked();

    public abstract void hoverElement();

    public abstract void leaveElement();

    public boolean isMouseHoverPossible() {
        return mouseHoverPossible;
    }

    public void setMouseHoverPossible(boolean mouseHover) {
        this.mouseHoverPossible = mouseHover;
    }

    public BufferedImage getElementImage() {
        return elementImage;
    }

    public BufferedImage getHoverImage() {
        return hoverImage;
    }

    public void setHoverImage(BufferedImage hoverImage) {
        this.hoverImage = hoverImage;
    }
}
