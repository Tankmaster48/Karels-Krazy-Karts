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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1920, 1024, 1); 
        
        loadWorld1();
    }
    
    public void loadWorld1() {
        PlayerCar pCar = new PlayerCar();
        AICar aCar = new GoodAI();
        boolean[][] hWalls = new boolean[30][16]; // 1 is horizontal 2 is vertical
        boolean[][] vWalls = new boolean[30][16];
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
        
        loadWalls(hWalls, vWalls);
        addObject(pCar, carCoord[0] * 64 + 32, carCoord[1] * 64 + 32);
        addObject(aCar, aiCarCoord[0] * 64 + 32, aiCarCoord[1] * 64 + 32);
        aCar.turn(270);
    }
    
    public void loadWalls(boolean[][] hWalls, boolean[][] vWalls) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 16; j++) {
                boolean hWall = hWalls[i][j];
                if (hWall)
                    addObject(new HorizontalWall(), 32 + 64 * i, 64 * j);
                boolean vWall = vWalls[i][j];
                if (vWall)
                    addObject(new VerticalWall(), 64 * i, 32 + 64 * j);
            }
        }
    }
    
    public void addHorizontalLine(boolean[][] walls, int x, int p1, int p2) {
        for (int i = p1; i <= p2; i++) {
            walls[i][x] = true;
        }
    }
    
    public void addVerticalLine(boolean[][] walls, int y, int p1, int p2) {
        for (int i = p1; i <= p2; i++) {
            walls[y][i] = true;
        }
    }
}
