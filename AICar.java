import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AICar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AICar extends Car
{
    /**
     * Act - do whatever the AICar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        super.act();
    }
    
    public boolean wallOnRight() {
        return getOneObjectAtOffset(10, 0, VerticalWall.class) != null || getOneObjectAtOffset(10, 0, HorizontalWall.class) != null;
    }
}
