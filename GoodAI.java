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
    int i = 0;
    public void act()
    {
        if (i % 20 == 0) {
            followWallRight();
        }
        i++;
    }
    
    public void followWallRight() {
        if (wallOnRight()) {
            if (frontIsClear()) {
                move();
            } else {
                turnLeft();
            }
        } else {
            turnRight();
        }
    }
}
