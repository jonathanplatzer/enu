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
import com.through_other_eyes.enu.core.GameCore;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class SplashScreen extends GameComponent {

    private ArrayList<BufferedImage> splashScreenImages;
    private long startTime;
    private int displayTime = 1 * 3000;
    private final File folder = new File("res/splash/");

    public SplashScreen() throws IOException {
        super(new Point(0, 0), new Dimension(GameCore.WIDTH, GameCore.HEIGHT));
        initialize();
    }

    private void initialize() throws IOException {
        splashScreenImages = new ArrayList<>();

        for (final File file : folder.listFiles()) {
            if (file.isFile()) {
                splashScreenImages.add(ImageIO.read(file));
//                System.out.println(file.getName());
            }
        }
    }

    @Override
    public void drawObject(Graphics2D g2) {
        if (this.isVisible()) {
            for (int i = 0; i < splashScreenImages.size(); i++) {
                if (startTime + displayTime * i < System.currentTimeMillis()) {
                    g2.drawImage(splashScreenImages.get(i), this.getPosition().x, this.getPosition().y, this.getDimension().width, this.getDimension().height, null);
                }
            }
        }
    }

    @Override
    public void move(float delta) {
    }

    @Override
    public void update() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }

        if (startTime + (splashScreenImages.size() * displayTime) < System.currentTimeMillis()) {
            this.setUpdateRequired(false);
            GameCore.state = GameCore.State.MAINMENU;
            GameCore.mainMenu.ANIMATE = true;
        }
    }

}
