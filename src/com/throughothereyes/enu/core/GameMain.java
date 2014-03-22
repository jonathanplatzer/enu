/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.throughothereyes.enu.core;

import com.throughothereyes.enu.utils.GameKeyListener;
import com.throughothereyes.enu.utils.GameWindowListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Jonathan Platzer
 * @date 22.03.2014
 */
public class GameMain extends JFrame {

    // Constants for the game
    private final int HEIGHT = 480;
    private final int WIDTH = 640;
    private final int BIT_DEPTH = 32;
    private final int REFRESH_RATE = 60;

    // Instances for fullscreen handling
    private final GraphicsDevice device;
    private DisplayMode originalDisplayMode;
    private DisplayMode gameDisplayMode;
    
    // Our custom drawing panel
    private GamePanel gamePanel;

    public GameMain(GraphicsDevice graphicsDevice) {
        device = graphicsDevice;
        
        initialize();
        
        setVisible(true);
    }
    
    private void initialize()
    {
        initializeUI();
        initializeListeners();
        initializeGame();
    }
    
    private void initializeGame()
    {
        
    }
    
    private void initializeListeners()
    {
        addKeyListener(new GameKeyListener(this));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new GameWindowListener(this));
    }

    private void initializeUI() {
        gamePanel = new GamePanel(WIDTH, HEIGHT);
        setContentPane(gamePanel);
        setTitle("Europa NON Universalis");
        
        if (device.isFullScreenSupported()) {
            setUndecorated(true);
            setVisible(true);
            originalDisplayMode = device.getDisplayMode();
            gameDisplayMode = new DisplayMode(WIDTH, HEIGHT, originalDisplayMode.getBitDepth(), DisplayMode.REFRESH_RATE_UNKNOWN);
            device.setFullScreenWindow(this);
            device.setDisplayMode(gameDisplayMode);
        } else {
            setResizable(false);
            pack();
        }
    }

    public void start() {

    }

    public void shutdown() {
        System.exit(0);
    }

    public void update() {

    }
    
    private 

    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultDevice = env.getDefaultScreenDevice();
        GameMain game = new GameMain(defaultDevice);
    }
}
