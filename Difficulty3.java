import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty3 extends Button
{
    /**
     * Act - do whatever the Difficulty3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car pCar) {
        ((MyWorld) getWorld()).setDifficulty(3);
        super.sound();
    }
}
