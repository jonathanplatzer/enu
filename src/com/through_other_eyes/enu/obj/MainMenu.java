/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.obj.base.Button;
import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.core.GamePanel;
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 * @author mwahlhuetter
 * @date 24.03.2014
 */
public class MainMenu extends GameComponent{
    
    private BufferedImage background;
    private ArrayList<UIElement> uIElements;

    public MainMenu(ArrayList<UIElement> uIElements) throws IOException {
        super(new Point(0, 0), new Dimension(GameCore.WIDTH, GameCore.HEIGHT));
        this.background = ImageIO.read(new File("res/mainmenu/background.png"));
        this.uIElements = uIElements;
        Button play = new Button(new Dimension(121, 27), ImageIO.read(new File("res/mainmenu/play.png")), "PLAY", GameCore.Align.CENTER, 0, 80);
        uIElements.add(play);
    }
    
    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(background, 0, 0, getDimension().width, getDimension().height, null);
        for(UIElement uilement : uIElements)
        {
            uilement.drawObject(g2);
        }
    }

    @Override
    public void move(float delta) {
    }

    @Override
    public void update() {
    }
}
