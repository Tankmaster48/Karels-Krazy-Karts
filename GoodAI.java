import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NiceAI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodAI extends AICar
{
    /**
     * Act - do whatever the NiceAI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int i = 0;
    
    public void act()
    {
        if (i % (6 * (4 - getDifficulty())) == 2) {
            // System.out.println(wallOnRight());
            followWallRight();
        }
        i++;
        super.act();
    }
    
    public void turnCorner() {
        turnRight();
        move();
    }
    
    public void followWallRight() {
        if (wallOnLeft() && !wallOnRight()) {
            turn(270);
            return;
        }
        if (!wallInFront()) {
            move();
        }
        else {
            turnLeft();
        }
        
        if (!wallOnRight()) {
            turnCorner();
        }
        
        if (!wallOnRight()) {
            turnCorner();
        }
    }
}