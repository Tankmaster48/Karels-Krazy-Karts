import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NotShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Beeper
{
    /**
     * Act - do whatever the NotShopButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void sound() {
        (new GreenfootSound("beep.wav")).play();
    }
}
