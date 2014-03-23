/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.obj.base.GameObject;
import com.through_other_eyes.enu.core.GameCore;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class SplashScreen extends GameObject {

    private ArrayList<BufferedImage> splashScreenImages;
    private long startTime;
    private int displayTime = 5*1000;
    private final File folder = new File("res/splash/");

    public SplashScreen() throws IOException {
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
    
    public GameCore.State doShit()
    {
        if(startTime == 0)
        {
            startTime = System.currentTimeMillis();
        }
        
        if(startTime + (splashScreenImages.size()*displayTime) < System.currentTimeMillis())
        {
            return GameCore.State.MAINMENU;
        }
        return GameCore.State.SPLASH;
    }

    @Override
    public void drawObject(Graphics2D g2) {
        if(startTime +5000 < System.currentTimeMillis())
        {
            g2.drawImage(splashScreenImages.get(1), 0, 0, 640, 480, null);
            return;
        }
        if (startTime < System.currentTimeMillis())
        {
            g2.drawImage(splashScreenImages.get(0), 0, 0, 640, 480, null);
            return;
        }
        return;
    }

    @Override
    public void move(float delta) {
        return;
    }

}
