import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightTurnUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightTurnUpgrade extends ShopButton
{
    /**
     * Act - do whatever the RightTurnUpgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public RightTurnUpgrade() {
        super();
        setPrice(300);
    }
    
    public void act()
    {
        super.act();
    }
    
    public void pick(Car car) {
        if (!((PlayerCar) car).hasCrashUpgrade()) {
            if (tryBuy(50, (PlayerCar) car)) {
                car.setCrashTime(99);
                ((PlayerCar) car).buyCrashUpgrade();
                setColor();
            } else {
                (new GreenfootSound("notbought.wav")).play();
            }
        } else {
            (new GreenfootSound("notbought.wav")).play();
        }
    }
}
