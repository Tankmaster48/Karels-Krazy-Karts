import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty1 extends Button
{
    /**
     * Act - do whatever the Difficulty1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car pCar) {
        ((MyWorld) getWorld()).setDifficulty(1);
        super.sound();
    }
}
