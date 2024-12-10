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
    private int price;
    private int i = 0;
    
    public void act()
    {
        if (i < 2) {
            i++;
        } else if (i == 2) {
            setColor();
            i++;
        }
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
    
    public boolean canBuy(int price, PlayerCar pCar) {
        return pCar.getMoney() >= price;
    }
    
    public void setColor() {
        if ((((MyWorld) getWorld()).getPlayer()).hasCrashUpgrade()) {
            setImage("yellowbeep.png");
        } else if (canBuy(price, ((MyWorld) getWorld()).getPlayer())) {
            setImage("greenbeep.png");
        }
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}
