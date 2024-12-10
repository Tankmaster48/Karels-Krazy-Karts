import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopButton extends Beeper
{
    /**
     * Act - do whatever the ShopButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootSound chaching = new GreenfootSound("chaching.wav");
    
    public void act()
    {
        // Add your action code here.
    }
    
    public boolean tryBuy(int price, PlayerCar pCar) {
        if (pCar.getMoney() >= price) {
            chaching.play();
            pCar.addMoney(-price);
            return true;
        } else {
            (new GreenfootSound("notbought.wav")).play();
            return false;
        }
    }
}
