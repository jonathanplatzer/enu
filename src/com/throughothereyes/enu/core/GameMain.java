/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.throughothereyes.enu.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 * @author Jonathan Platzer
 * @date 22.03.2014
 */
public class GameMain extends JFrame {

    private final GraphicsDevice device;
    private DisplayMode displayMode;
    private GamePanel gamePanel;

    public GameMain(GraphicsDevice device) {
        this.device = device;
    }

    public void initialize() {
        if (device.isFullScreenSupported()) {
            setUndecorated(true);
            setLayout(null);
            getContentPane().setBackground(Color.BLACK);
            displayMode = device.getDisplayMode();
            device.setFullScreenWindow(this);
            device.setDisplayMode(new DisplayMode(640, 480, 32, 60));
            int height = 480;//displayMode.getHeight();
            int width = 640;//(int)Math.round(1.3333333333333*displayMode.getHeight());
            float zoomRatio = height/480f;
            gamePanel = new GamePanel(width, height, zoomRatio);
//            gamePanel.setBounds((displayMode.getWidth() - width) / 2, 0, width, height);
            add(gamePanel);
            validate();
            setVisible(true);
        } else {
            setResizable(false);
        }
    }

    public void start() {
        
    }

    public void shutdown() {
        
    }

    public void update() {
        
    }

    public void draw(Graphics2D g2d) {
        
    }

    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultDevice = env.getDefaultScreenDevice();
        GameMain game = new GameMain(defaultDevice);
        game.initialize();
    }
}
