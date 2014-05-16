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
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mwahlhuetter
 * @date 05.04.2014
 */
public class ExitButton extends Button {

    public ExitButton(Point position, File elementImage) throws IOException {
        super(position, elementImage);
    }

    public ExitButton(File elementImage, GameCore.Align align, int offset, int y) throws IOException {
        super(elementImage, align, offset, y);
    }

    @Override
    public void clicked() {
        GameCore.state = GameCore.State.SHUTDOWN;
    }

    private boolean hoverAnimation = false;

    @Override
    public void hoverElement() {
        if (!hoverAnimation && isMouseHoverPossible()) {
            hoverAnimation = true;
            Thread animationThread = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 2; i++) {
                        setPosition(new Point(getPosition().x - 3, getPosition().y - 1));
                        setDimension(new Dimension(getDimension().width + 6, getDimension().height + 2));
//                        setPosition(new Point(getPosition().x, getPosition().y - 4)); FUN WITH PLAY BUTTON
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PlayButton.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    hoverAnimation = false;
                }
            };
            animationThread.start();
        }
    }

    @Override
    public void leaveElement() {
        Thread animationThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    setPosition(new Point(getPosition().x + 3, getPosition().y + 1));
                    setDimension(new Dimension(getDimension().width - 6, getDimension().height - 2));
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        animationThread.start();
    }
}
