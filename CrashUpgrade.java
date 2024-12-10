import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrashUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrashUpgrade extends ShopButton
{
    /**
     * Act - do whatever the CrashUpgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car car) {
        if (tryBuy(50, (PlayerCar) car)) car.setCrashTime(100);
    }
}
