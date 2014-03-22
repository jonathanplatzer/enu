/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.throughothereyes.enu.core;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * @author Jonathan Platzer
 * @date 22.03.2014
 */
public class GameMain extends JFrame implements KeyListener {

    private final int HEIGHT = 480;
    private final int WIDTH = 640;
    private final int BIT_DEPTH = 32;
    private final int REFRESH_RATE = 60;

    private final GraphicsDevice device;
    private DisplayMode originalDisplayMode;
    private DisplayMode gameDisplayMode;
    private GamePanel gamePanel;

    public GameMain(GraphicsDevice device) {
        this.device = device;
        addKeyListener(this);
    }

    public void initialize() {
        if (device.isFullScreenSupported()) {
            setUndecorated(true);
            originalDisplayMode = device.getDisplayMode();
            gameDisplayMode = new DisplayMode(WIDTH, HEIGHT, originalDisplayMode.getBitDepth(), DisplayMode.REFRESH_RATE_UNKNOWN);
            device.setFullScreenWindow(this);
            device.setDisplayMode(gameDisplayMode);
        } else {
            setResizable(false);
            getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        }

        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        gamePanel = new GamePanel(WIDTH, HEIGHT);
        add(gamePanel);
        validate();
        setVisible(true);
    }

    public void start() {

    }

    public void shutdown() {
        System.exit(0);
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

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + " pressed");
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) { 
         shutdown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode() + " released");
    }
}
