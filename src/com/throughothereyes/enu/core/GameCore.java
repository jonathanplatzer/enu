/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.throughothereyes.enu.core;

import com.throughothereyes.enu.utils.InputController;
import com.throughothereyes.enu.utils.WindowController;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class GameCore extends JFrame {

    // <editor-fold defaultstate="collapsed" desc="Instances">
    
    // Constants for the game
    private final int HEIGHT = 480;
    private final int WIDTH = 640;
    private final int BIT_DEPTH = 32;
    private final int REFRESH_RATE = 60;
    
    // Static enum for states of the game
    public static enum State{
        SPLASH, MAINMENU, PLAY, PAUSED, GAMEOVER, SHUTDOWN
    }
    
    // Static variable to access the current state of the game
    public static State state;

    // Instances for fullscreen handling
    private final GraphicsDevice device;
    private DisplayMode originalDisplayMode;
    private DisplayMode gameDisplayMode;

    // Panel for drawing the GameObjects
    private GamePanel gamePanel;

    // Instances for Controllers
    InputController inputController;
    WindowController windowController;

    // </editor-fold>
    
    public GameCore(GraphicsDevice graphicsDevice) {
        device = graphicsDevice;

        initialize();

        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Initialization">
    private void initializeGame() {

    }

    private void initialize() {
        initializeUI();
        initializeListeners();
    }

    private void initializeListeners() {
        inputController = new InputController(this);
        windowController = new WindowController(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addKeyListener(inputController);
        addWindowListener(windowController);
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

    // </editor-fold>
    
    private void gameLoop() {
        GameCore.state = GameCore.State.SPLASH;
        while (true) {
            repaint();
        }
    }

    public void start() {
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        
        gameThread.start();
    }

    public void update() {

    }

    public void shutdown() {
        System.exit(0);
    }

    // <editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice defaultDevice = env.getDefaultScreenDevice();
                GameCore game = new GameCore(defaultDevice);
                game.start();
            }
        });
    }

    // </editor-fold>
}
