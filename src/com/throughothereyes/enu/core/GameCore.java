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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class GameCore extends JFrame {

    // <editor-fold defaultstate="collapsed" desc="Instances">
    // Constants for the game
    static final int HEIGHT = 480;
    static final int WIDTH = 640;
    static final int BIT_DEPTH = 32;
    static final int REFRESH_RATE = 60;
    static final int UPDATE_RATE = 30;
    static final long UPDATE_PERIOD = (long) 1e9 / UPDATE_RATE;

    // Static enum for states of the game
    static enum State {

        SPLASH, MAINMENU, PLAY, PAUSED, GAMEOVER, SHUTDOWN
    }

    // Static variable to access the current state of the game
    public static State state;

    public static int fps;

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
        // <editor-fold defaultstate="collapsed" desc="A bunch of variables">
        long startTime;
        long deltaTime;
        long sleepTime;
        long splashStartTime = 0;
        int splashDisplayTime = (int) (3.5 * 1000);

        if (state == State.SPLASH) {
            splashStartTime = System.currentTimeMillis();
        }
        // </editor-fold>
        while (true) {
            startTime = System.nanoTime();
            if (state == State.GAMEOVER) {
                break;
            }
            if (state == State.SPLASH) {
                if (splashStartTime + splashDisplayTime < System.currentTimeMillis()) {
                    state = State.MAINMENU;
                }
            }
            repaint();

            deltaTime = System.nanoTime() - startTime;
            sleepTime = (UPDATE_PERIOD - deltaTime) / (long) 1e6;
            if (sleepTime < 0) {
                sleepTime = 0;
            }
            fps = (int) (1000 / ((deltaTime / (long) 1e6) + sleepTime));
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void start() {
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                GameCore.state = GameCore.State.SPLASH;
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
