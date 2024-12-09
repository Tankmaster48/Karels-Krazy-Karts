import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty2 extends Beeper
{
    /**
     * Act - do whatever the Difficulty2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car pCar) {
        ((MyWorld) getWorld()).setDifficulty(2);
    }
}
