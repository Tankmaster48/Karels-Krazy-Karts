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
        addHorizontalLine(hWalls,5, 0, 10);
        
        int[] carCoord = {5, 5};
        int[] aiCarCoord = {6, 5};
        
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
                    addObject(new HorizontalWall(), 32 + 64 * j, 64 * i);
                boolean vWall = vWalls[i][j];
                if (vWall)
                    addObject(new VerticalWall(), 64 * j, 32 + 64 * i);
            }
        }
    }
    
    public void addHorizontalLine(boolean[][] walls, int row, int p1, int p2) {
        for (int i = p1; i < p2; i++) {
            walls[row][i] = true;
        }
    }
    
    public void addVerticalLine(boolean[][] walls, int col, int p1, int p2) {
        for (int i = p1; i < p2; i++) {
            walls[i][col] = true;
        }
    }
}
