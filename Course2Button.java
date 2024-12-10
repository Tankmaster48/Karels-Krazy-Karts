import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Course2Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Course2Button extends Button
{
    /**
     * Act - do whatever the Course2Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    @Override
    public void pick(Car pCar) {
        MyWorld world = (MyWorld) getWorld();
        world.removeMenu();
        world.loadWorld2((PlayerCar) pCar);
        super.sound();
    }
}
