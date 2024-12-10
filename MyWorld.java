import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int lapsToWin;
    private int worldId;
    private int reward;
    private int difficulty = 2;
    private boolean freeze;
    private PlayerCar pCar;
    private GreenfootSound ambience = new GreenfootSound("ambience.wav");
    private GreenfootSound winSound = new GreenfootSound("win.wav");
    private GreenfootSound loseSound = new GreenfootSound("loss.wav");
    
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1920, 1024, 1);
        ambience.setVolume(30);
        setPaintOrder(GuiActor.class, Car.class, Title.class, Wall.class, Beeper.class, AccessoryTile.class, Tile.class);
        
        pCar = new PlayerCar();
        addObject(pCar, 0, 0);
        loadMenu(pCar);
        
        loadGui();
    }
    
    public void goMenu() {
        switch (worldId) {
            case 0:
                removeWorld0();
                loadMenu(getObjects(PlayerCar.class).get(0));
                break;
            case 1:
                removeWorld1();
                loadMenu(getObjects(PlayerCar.class).get(0));
                break;
            default:
                removeMenu();
                break;
        }
    }
    
    public void removeMenu() {
        clearCourse();
        showText(null, 96, 480);
        showText(null, 800, 480);
        showText(null, 160, 440);
        showText(null, 224, 320);
        showText(null, 96, 544);
        pCar.setSound(true);
    }
    
    public void removeWorld0() {
        clearCourse();
    }
    
    public void removeWorld1() {
        clearCourse();
    }
    
    public void loadWalls(boolean[][] hWalls, boolean[][] vWalls) {
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 17; j++) {
                boolean hWall = hWalls[i][j];
                if (hWall)
                    addObject(new HorizontalWall(), 32 + 64 * i, 64 * j);
                boolean vWall = vWalls[i][j];
                if (vWall)
                    addObject(new VerticalWall(), 64 * i, 32 + 64 * j);
            }
        }
    }
    
    public void loadAllTiles(boolean[][][] tileLists) {
        for (int i = 0; i < tileLists.length; i++) {
            loadTiles(tileLists[i], i);
        }
    }
    
    public void loadTiles(boolean[][] tiles, int tileId) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 16; j++) {
                if (tiles[i][j]) {
                    Tile tile;
                    switch (tileId) {
                        case 0:
                            tile = new FirstFinishLine();
                            break;
                        case 1:
                            tile = new FinishLine();
                            break;
                        case 2:
                            tile = new Grass();
                            break;
                        case 3:
                            tile = new Road1();
                            break;
                        case 4:
                            tile = new Wood();
                            break;
                        default:
                            tile = new FirstFinishLine();
                            break;
                    }
                    addObject(tile, 32 + 64 * i, 32 + 64 * j);
                }
            }
        }
    }
    
    public void addRectangle(boolean[][] coords, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            addVerticalLine(coords, i, y1, y2);
        }
    }
    
    public void addHorizontalLine(boolean[][] coords, int x, int p1, int p2) {
        for (int i = p1; i <= p2; i++) {
            coords[i][x] = true;
        }
    }
    
    public void addVerticalLine(boolean[][] coords, int y, int p1, int p2) {
        for (int i = p1; i <= p2; i++) {
            coords[y][i] = true;
        }
    }
    
    public void win(Car winner) {
        winner.setCrash(240);
        if (winner.getClass() == PlayerCar.class) {
            ((PlayerCar) winner).addMoney(reward);
            winSound.play();
        } else {
            loseSound.play();
        }
        freeze = true;
    }
    
    public void start() {
        freeze = true;
        addObject(new StartLight(), 64 * 15, 64 * 8);
    }
    
    public void startMusic() {
        ambience.play();
    }
    
    public void stopMusic() {
        ambience.stop();
    }
    
    public void end() {
        switch(worldId) {
            case 1:
                goMenu();
                break;
        }
        stopMusic();
        freeze = false;
    }
    
    public void clearCourse() {
        removeObjects(getObjects(CourseElement.class));
        removeObjects(getObjects(AICar.class));
    }
    
    public void loadGui() {
        addObject(new Coin(), 48, 32);
        showText("Difficulty:", 128, 32);
        updateMoney();
        updateDifficulty();
    }
    
    public void updateMoney() {
        showText(Integer.toString(pCar.getMoney()), 32, 32);
    }
    
    public void updateDifficulty() {
        showText(Integer.toString(difficulty), 192, 32);
    }
    
    public int getLaps() {
        return lapsToWin;
    }
    
    public boolean getFreeze() {
        return freeze;
    }
    
    public int getReward() {
        return reward;
    }
    
    public int getDifficulty() {
        return difficulty;
    }
    
    public PlayerCar getPlayer() {
        return pCar;
    }
    
    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }
    
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        updateDifficulty();
    }
    
    public void loadWorld0(PlayerCar pCar) {
        AICar aCar = new GoodAI();
        boolean[][] hWalls = new boolean[31][17]; // 1 is horizontal 2 is vertical
        boolean[][] vWalls = new boolean[31][17];
        boolean[][] firstFinishLines = new boolean[30][16];
        boolean[][] finishLines = new boolean[30][16];
        lapsToWin = 2;
        worldId = 0;
        
        addVerticalLine(firstFinishLines, 5, 10, 13);
        
        addHorizontalLine(hWalls, 1, 0, 25);
        addHorizontalLine(hWalls, 14, 0, 25);
        addVerticalLine(vWalls, 1, 0, 13);
        addVerticalLine(vWalls, 26, 0, 13);
        
        addVerticalLine(vWalls, 3, 3, 11);
        addVerticalLine(vWalls, 24, 3, 11);
        addHorizontalLine(hWalls, 3, 3, 23);
        addHorizontalLine(hWalls, 12, 3, 23);
        
        int[] carCoord = {2, 5};
        int[] aiCarCoord = {1, 5};
        
        loadTiles(firstFinishLines, 0);
        loadWalls(hWalls, vWalls);
        // addObject(pCar, carCoord[0] * 64 + 32, carCoord[1] * 64 + 32);
        pCar.setLocation(carCoord[0] * 64 + 32, carCoord[1] * 64 + 32);
        pCar.setRotation(90);
        addObject(aCar, aiCarCoord[0] * 64 + 32, aiCarCoord[1] * 64 + 32);
        aCar.turn(270);
    }
    
    public void loadWorld1(PlayerCar pCar) {
        AICar aCar = new GoodAI();
        aCar.setSound(true);
        boolean[][] hWalls = new boolean[31][17]; // 1 is horizontal 2 is vertical
        boolean[][] vWalls = new boolean[31][17];
        boolean[][] firstFinishLines = new boolean[30][16];
        boolean[][] finishLines = new boolean[30][16];
        boolean[][] grasses = new boolean[30][16];
        boolean[][] roads = new boolean[30][16];
        boolean[][] woods = new boolean[30][16];
        boolean[][][] tileLists = {firstFinishLines, finishLines, grasses, roads, woods};
        lapsToWin = 2;
        worldId = 1;
        reward = 50;
        
        addHorizontalLine(firstFinishLines, 6, 1, 4);
        addHorizontalLine(finishLines, 7, 1, 4);
        addVerticalLine(grasses, 0, 0, 15);
        addVerticalLine(grasses, 26, 0, 15);
        addHorizontalLine(grasses, 0, 1, 25);
        addRectangle(roads, 1, 1, 25, 15);
        
        addHorizontalLine(hWalls, 1, 1, 25);
        addHorizontalLine(hWalls, 15, 5, 22);
        addVerticalLine(vWalls, 1, 1, 15);
        addVerticalLine(vWalls, 23, 4, 14);
        addVerticalLine(vWalls, 26, 1, 15);
       
        addVerticalLine(vWalls, 5, 3, 14);
        addVerticalLine(vWalls, 20, 1, 12);
        addHorizontalLine(hWalls, 3, 3, 15);
        addHorizontalLine(hWalls, 5, 7, 19);
        addHorizontalLine(hWalls, 7, 5, 15);
        addHorizontalLine(hWalls, 9, 7, 19);
        addHorizontalLine(hWalls, 11, 5, 15);
        addHorizontalLine(hWalls, 13, 7, 19);
        addHorizontalLine(hWalls, 16, 0, 25);
        int[] carCoord = {3, 5};
        int[] aiCarCoord = {1, 5};
        
        loadWalls(hWalls, vWalls);
        loadAllTiles(tileLists);
        // addObject(pCar, carCoord[0] * 64 + 32, carCoord[1] * 64 + 32);
        pCar.setLocation(carCoord[0] * 64 + 32, carCoord[1] * 64 + 32);
        pCar.setRotation(90);
        addObject(aCar, aiCarCoord[0] * 64 + 32, aiCarCoord[1] * 64 + 32);
        aCar.turn(90);
        start();
    }
    
    public void loadMenu(PlayerCar pCar) {
        // 1 is horizontal 2 is vertical
        boolean[][] hWalls = new boolean[31][17];
        boolean[][] vWalls = new boolean[31][17];
        boolean[][] firstFinishLines = new boolean[30][16];
        boolean[][] finishLines = new boolean[30][16];
        boolean[][] grasses = new boolean[30][16];
        boolean[][] roads = new boolean[30][16];
        boolean[][] woods = new boolean[30][16];
        boolean[][][] tileLists = {firstFinishLines, finishLines, grasses, roads, woods};
        worldId = 0;
        int[] carCoord = {7, 9};
       
        addRectangle(woods, 2, 3, 12, 5);
        addVerticalLine(woods, 7, 6, 7);
        addRectangle(woods, 6, 8, 8, 10);
        addHorizontalLine(woods, 9, 4, 5);
        addHorizontalLine(woods, 9, 9, 10);
        addRectangle(woods, 1, 8, 3, 10);
        addRectangle(woods, 11, 8, 13, 10);
        addRectangle(grasses, 0, 0, 29, 15);
        // addObject(new Title(), 480, 96);
        showText("Shop", 160, 440);
        addVerticalLine(vWalls, 1, 8, 10);
        addHorizontalLine(hWalls, 8, 1, 3);
        addHorizontalLine(hWalls, 11, 1, 3);
        addVerticalLine(vWalls, 4, 8, 8);
        addVerticalLine(vWalls, 4, 10, 10);
        addVerticalLine(vWalls, 9, 8, 8);
        addHorizontalLine(hWalls, 9, 4, 5);
        addHorizontalLine(hWalls, 10, 4, 5);
        addVerticalLine(vWalls, 9, 10, 10);
        addHorizontalLine(hWalls, 11, 6, 8);
        addHorizontalLine(hWalls, 8, 6, 6);
        addVerticalLine(vWalls, 8, 6, 7);
        addVerticalLine(vWalls, 7, 6, 7);
        addHorizontalLine(hWalls, 8, 8, 8);
        showText("Garage", 800,480);
        addHorizontalLine(hWalls, 6, 2, 6);
        addHorizontalLine(hWalls, 6, 8, 12);
        addVerticalLine(vWalls, 2, 3, 5);
        addVerticalLine(vWalls, 13, 3, 5);
        addHorizontalLine(hWalls, 3, 2, 12);
        addVerticalLine(vWalls, 6, 8, 8);
        addHorizontalLine(hWalls, 9, 9, 10);
        addHorizontalLine(hWalls, 10, 9, 10);
        addVerticalLine(vWalls, 6, 10, 10);
        addVerticalLine(vWalls, 14, 8, 10);
        addHorizontalLine(hWalls, 8, 11, 13);
        addHorizontalLine(hWalls, 11, 11, 13);
        addVerticalLine(vWalls, 11, 8, 8);
        addVerticalLine(vWalls, 11, 10, 10);
        loadWalls(hWalls, vWalls);
        loadAllTiles(tileLists);
        showText("Difficulty", 224, 320);

        addObject(new Course1Button(), 160, 224);
        addObject(new Difficulty1(), 160, 352);
        addObject(new Difficulty2(), 224, 352);
        addObject(new Difficulty3(), 288, 352);
        addObject(new CrashUpgrade(), 96, 544);
        addObject(new CraigCarButton(), 736, 544);
        addObject(new LiweiCarButton(), 864, 544);
        addObject(new JoshuaCarButton(), 736, 672);
        addObject(new RedCarButton(), 864, 672);
        showText("50", 96, 544);
        addObject(new Title(), 480, 160);
        showText("Reduce\nCrash\nTime", 96, 480);
        
        pCar.setLocation(carCoord[0] * 64 + 32, carCoord[1] * 64 + 32);
        pCar.setSound(false);
    }
}