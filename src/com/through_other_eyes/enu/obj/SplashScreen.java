/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class SplashScreen extends GameComponent {

    private ArrayList<BufferedImage> splashScreenImages;
    private long startTime;
    private int displayTime = 3 * 1000;
    private final File folder = new File("res/splash/");

    public SplashScreen() throws IOException {
        super(new Point(0, 0), new Dimension(GameCore.WIDTH, GameCore.HEIGHT), true);
        initialize();
    }

    private void initialize() throws IOException {
        splashScreenImages = new ArrayList<>();

        for (final File file : folder.listFiles()) {
            if (file.isFile()) {
                splashScreenImages.add(ImageIO.read(file));
                System.out.println(file.getName());
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
        }
    }

}
