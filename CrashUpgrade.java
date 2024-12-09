import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrashUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrashUpgrade extends Beeper
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
        PlayerCar pCar = (PlayerCar) car;
        if (pCar.getMoney() > 50) {
            pCar.addMoney(-50);
            pCar.setCrashTime(100);
        } else {
            // play a not good sound
        }
    }
}
