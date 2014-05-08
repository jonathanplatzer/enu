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

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public abstract class GameComponent implements Drawable, Moveable{
    private Point position;
    private Dimension dimension;
    private boolean visible = true;
    private boolean updateRequired = true;

    public GameComponent() {
    }

    public GameComponent(Point position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
    }

    public GameComponent(Point position, Dimension dimension, boolean visible) {
        this.position = position;
        this.dimension = dimension;
        this.visible = visible;
    }
    
    public GameComponent(Point position, Dimension dimension, boolean visible, boolean updateRequired)
    {
        this.position = position;
        this.dimension = dimension;
        this.visible = visible;
        this.updateRequired = updateRequired;
    }
    
    public abstract void update();

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isUpdateRequired() {
        return updateRequired;
    }

    public void setUpdateRequired(boolean updateRequired) {
        this.updateRequired = updateRequired;
    }
}
