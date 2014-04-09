/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.GameComponent;
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
    private ArrayList<UIElement> uIElements;

    public boolean ANIMATE = false;
    
    public MainMenu(ArrayList<UIElement> uIElements) throws IOException {
        super(new Point(0, 0), new Dimension(GameCore.WIDTH, GameCore.HEIGHT), true, true);
        this.background = ImageIO.read(new File("res" + File.separator + "mainmenu" + File.separator + "background.png"));
        this.uIElements = uIElements;
        PlayButton play = new PlayButton(ImageIO.read(new File("res" + File.separator + "mainmenu" + File.separator + "play.png")), GameCore.Align.CENTER, 0, 80);
        uIElements.add(play);
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(background, 0, 0, getDimension().width, getDimension().height, null);
        for (UIElement uilement : uIElements) {
            uilement.drawObject(g2);
        }
    }

    @Override
    public void move(float delta) {
        if (ANIMATE) {
            for (UIElement uilement : uIElements) {
                uilement.move(delta);
            }
        }
    }

    @Override
    public void update() {
    }
}
