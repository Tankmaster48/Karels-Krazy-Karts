import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Course1Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Course1Button extends Beeper
{
    /**
     * Act - do whatever the Course1Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    @Override
    public void pick(PlayerCar pCar) {
        MyWorld world = (MyWorld) getWorld();
        world.removeMenu();
        world.loadWorld1(pCar);
    }
}
