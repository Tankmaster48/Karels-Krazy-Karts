import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        super(1920, 1080, 1); 
        
        loadWorld1();
    }
    
    public void loadWorld1() {
        PlayerCar che = new PlayerCar();
        addObject(che, 126, 128); // subtract 4 from x
        VerticalWall wall = new VerticalWall();
        addObject(wall, 160, 160);
    }
}
