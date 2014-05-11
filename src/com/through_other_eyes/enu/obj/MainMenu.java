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
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.Resource;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author mwahlhuetter
 * @date 24.03.2014
 */
public class MainMenu extends GameComponent {

    private BufferedImage background;
    private ArrayList<UIElement> uiElements;

    public boolean ANIMATE = false;
    
    public MainMenu() throws IOException {
        super(new Point(0, 0), new Dimension(GameCore.WIDTH, GameCore.HEIGHT), true, true);
        this.background = ImageIO.read(new File(Resource.MAINMENU_BACKGROUND));
        this.uiElements = new ArrayList<>();
        PlayButton play = new PlayButton(Resource.PLAY, GameCore.Align.CENTER, 0, 80);
        ExitButton exit = new ExitButton(Resource.PLAY, GameCore.Align.CENTER, 0, 160);
        uiElements.add(play);
        uiElements.add(exit);
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(background, 0, 0, getDimension().width, getDimension().height, null);
        for (UIElement uilement : uiElements) {
            uilement.drawObject(g2);
        }
    }

    @Override
    public void move(float delta) {
        if (ANIMATE) {
            for (UIElement uilement : uiElements) {
                uilement.move(delta);
            }
        }
    }

    @Override
    public void update() {
    }

    public ArrayList<UIElement> getUiElements() {
        return uiElements;
    }
}
