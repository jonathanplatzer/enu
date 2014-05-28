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
package com.through_other_eyes.enu.core;

import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.Resource;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class GamePanel extends JPanel {

    private ArrayList<ArrayList<GameComponent>> renderObjects;
    //private Graphics2D g2;

    public GamePanel(int width, int height, ArrayList<ArrayList<GameComponent>> renderObjects) {
        this.setPreferredSize(new Dimension(width, height));
        this.renderObjects = renderObjects;
        this.setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        switch (GameCore.state) {
            case SPLASHSCREEN:
                for (GameComponent gameComponent : renderObjects.get(0)) {
                    if (gameComponent.isVisible()) {
                        gameComponent.drawObject(g2);
                    }
                }
                break;

            case MAINMENU:
                for (GameComponent gameComponent : renderObjects.get(1)) {
                    if (gameComponent.isVisible()) {
                        gameComponent.drawObject(g2);
                    }
                }
                break;
            case PLAY:
                for (GameComponent gameComponent : renderObjects.get(2)) {
//                    System.out.println(gameComponent + " " + gameComponent.isVisible());
                    if (gameComponent.isVisible()) {
//                        System.out.println(gameComponent + " " + gameComponent.isVisible());
                        gameComponent.drawObject(g2);
                    }
                }
                break;
            case PAUSED:
                for (GameComponent gameComponent : renderObjects.get(3)) {
                    if (gameComponent.isVisible()) {
                        gameComponent.drawObject(g2);
                    }
                }
                break;
        }

        if (GameCore.debugMode) {
            renderDebugInformation(g2);
        }

        //Easter Egg
        if (GameCore.doge) {
            try {
                g2.drawImage(ImageIO.read(Resource.DOGE), 320 - 75, 210, null);
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void renderDebugInformation(Graphics2D g2) {

        g2.setColor(new Color(0, 186, 255));
        g2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        g2.drawString("Europa NON Universalis -- DEBUG MODE --", 2, 12);
        g2.drawString("---------------------------------------", 2, 20);
        g2.drawString("GAMESTATE: " + GameCore.state, 2, 30);
        g2.drawString("FPS: " + Long.toString(GameCore.fps), 2, 42);
        g2.drawString("DELTATIME: " + GameCore.dt, 2, 54);
        g2.drawString(String.format("TOTAL MEMORY: %dMB", Runtime.getRuntime().totalMemory() / 1024 / 1024), 2, 66);
        g2.drawString(String.format("USED MEMORY: %dMB", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024), 2, 78);
        g2.drawString(time(), 2, 90);
    }

    private String time() {
        long timeInMilliSeconds = System.currentTimeMillis() - GameCore.startTime;
        long seconds = timeInMilliSeconds / 1000 % 60;
        long minutes = timeInMilliSeconds / 1000 / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        return String.format("TIME RUNNING: %02d:%02d:%02d:%03d", hours, minutes, seconds, timeInMilliSeconds % 1000);
    }
}
