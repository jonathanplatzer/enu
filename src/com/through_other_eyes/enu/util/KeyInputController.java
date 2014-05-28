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
package com.through_other_eyes.enu.util;

import com.through_other_eyes.enu.core.GameCore;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author mwahlhuetter
 * @date 22.03.2014
 */
public class KeyInputController implements KeyListener {

    public KeyInputController() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (GameCore.state == GameCore.State.PLAY || GameCore.state == GameCore.State.PAUSED) {
                if (GameCore.state != GameCore.State.PAUSED) {
                    GameCore.state = GameCore.State.PAUSED;
                } else {
                    GameCore.state = GameCore.State.PLAY;
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_F1) {
            GameCore.debugMode = !GameCore.debugMode;
        }
        //Easter Egg
        if (e.getKeyCode() == KeyEvent.VK_D) {
            GameCore.doge = !GameCore.doge;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode() + " released");
    }

}
