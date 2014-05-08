/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.core;

import com.through_other_eyes.enu.obj.MainMenu;
import com.through_other_eyes.enu.obj.Map;
import com.through_other_eyes.enu.obj.QuestionDialog;
import com.through_other_eyes.enu.obj.SplashScreen;
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.UIElement;
import com.through_other_eyes.enu.util.KeyInputController;
import com.through_other_eyes.enu.util.MouseInputController;
import com.through_other_eyes.enu.util.WindowController;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public class GameCore extends JFrame {

    // <editor-fold defaultstate="collapsed" desc="Instances">
    // Constants for the game
    public static final int HEIGHT = 480;
    public static final int WIDTH = 640;
    public static final int BIT_DEPTH = 32;
    public static final int REFRESH_RATE = 60;
    public static final int UPDATE_RATE = 30;
    public static final long UPDATE_PERIOD = (long) 1e9 / UPDATE_RATE;

    /**
     * Static enum for states of the game
     */
    public static enum State {

        SPLASHSCREEN, MAINMENU, PLAY, PAUSED, GAMEOVER, SHUTDOWN
    }

    /**
     * Static enum for the alignment of the buttons on the UI
     */
    public static enum Align {

        LEFT, CENTER, RIGHT, NOTHING
    }

    /**
     * Static enum for the different states of a buton
     */
    public static enum UIElementState {

        DEFAULT, HOVER
    }

    // Static variables to access data like state of the game, fps or dt
    public static State state = State.SPLASHSCREEN;
    public static int fps;
    public static float dt;
    public static boolean debugMode = true;
    public static long startTime;
    public static MainMenu mainMenu;
    public static Map map;
    public static QuestionDialog questionDialog;

    // Instances for fullscreen handling
    private final GraphicsDevice device;
    private DisplayMode originalDisplayMode;
    private DisplayMode gameDisplayMode;

    // Panel for drawing the GameObjects
    private GamePanel gamePanel;
    private ArrayList<ArrayList<GameComponent>> renderObjects;
    private ArrayList<GameComponent> splashscreenRenderObjects;
    private ArrayList<GameComponent> mainMenuRenderObjects;
    private ArrayList<GameComponent> playRenderObjects;

    // SplashScreen that is shown on startup
    //private SplashScreen splash = null;
    // Instances for Controllers
    private WindowController windowController;
    private KeyInputController keyInputController;
    private MouseInputController mouseInputController;

    // </editor-fold>
    public GameCore(GraphicsDevice graphicsDevice) {
        device = graphicsDevice;
        renderObjects = new ArrayList<>();
        startTime = System.currentTimeMillis();

        initialize();

        try {
            mainMenu = new MainMenu();
            map = new Map(ImageIO.read(new File("res" + File.separator + "map_small.png")));
            map.setUpdateRequired(false);
            questionDialog = new QuestionDialog(ImageIO.read(new File("res" + File.separator + "questiondialog.png")), GameCore.Align.CENTER, 0, 60);
            //questionDialog.setVisible(true);

            mainMenuRenderObjects.add(mainMenu);
            playRenderObjects.add(map);
            playRenderObjects.add(questionDialog);

            renderObjects.add(splashscreenRenderObjects);
            renderObjects.add(mainMenuRenderObjects);
            renderObjects.add(playRenderObjects);
        } catch (IOException ex) {
            Logger.getLogger(GameCore.class.getName()).log(Level.SEVERE, null, ex);
        }

        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Initialization">

    private void initialize() {
        initializeUI();
        initializeListeners();
        initializeSplashScreen();
        initializeMainMenu();
        initializeMap();
    }

    private void initializeListeners() {
        windowController = new WindowController();
        keyInputController = new KeyInputController();
        mouseInputController = new MouseInputController();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(windowController);
        addKeyListener(keyInputController);
        addMouseListener(mouseInputController);
        addMouseWheelListener(mouseInputController);
        addMouseMotionListener(mouseInputController);
    }
    
    private void initializeUI() {
        gamePanel = new GamePanel(WIDTH, HEIGHT, renderObjects);
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
            setLocationRelativeTo(null);
        }
    }

    private void initializeSplashScreen() {
        splashscreenRenderObjects = new ArrayList<>();
        //Ingame SplashScreen
        try {
            splashscreenRenderObjects.add(new SplashScreen());
        } catch (IOException ex) {
            Logger.getLogger(GameCore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initializeMainMenu() {
        mainMenuRenderObjects = new ArrayList<>();
    }

    private void initializeMap() {
        playRenderObjects = new ArrayList<>();
    }
    
    private void initializeGame() {
    }
    
    // </editor-fold>
    private void computeData(double deltaTime, double sleepTime) {
        fps = (int) (1000 / ((deltaTime / 1000000.0) + sleepTime));
        dt = 1f / fps;
    }

    private void renderLoop() {
        long startTime;
        double deltaTime;
        double sleepTime;

        while (true) {
            startTime = System.nanoTime();
            update();
            repaint();

            deltaTime = System.nanoTime() - startTime;
            sleepTime = (UPDATE_PERIOD - deltaTime) / (long) 1e6;
            if (sleepTime < 0) {
                sleepTime = 0;
            }
            computeData(deltaTime, sleepTime);
            try {
                Thread.sleep((int) sleepTime);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void update() {
        switch (state) {
            case MAINMENU:
                break;
            case PLAY:
                break;
            case PAUSED:
                break;
            case SHUTDOWN:
                shutdown();
                break;
        }
        for (ArrayList<GameComponent> activeRenderObjects : renderObjects) {
            for (GameComponent object : activeRenderObjects) {
                if (object.isUpdateRequired()) {
                    object.update();
                    object.move(dt);
                }
            }
        }
    }

    private void updateGame() {
    }

    public void start() {
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                renderLoop();
            }
        };

        gameThread.start();
    }

    private void shutdown() {
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
