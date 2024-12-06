import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerCar extends Car
{
    /**
     * Act - do whatever the PlayerCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean wLast = false;
    private boolean aLast = false;
    private boolean spaceLast = false;
    private int money;
    
    public void act()
    {
        if (Greenfoot.isKeyDown("up") && !wLast) {
            move();
        }
        if (Greenfoot.isKeyDown("left") && !aLast) {
            turnLeft();
        }
        if (Greenfoot.isKeyDown("space") && !spaceLast) {
            pickBeeper();
        }
        wLast = Greenfoot.isKeyDown("up");
        aLast = Greenfoot.isKeyDown("left");
        spaceLast = Greenfoot.isKeyDown("space");
        super.act();
    }
    
    public void addMoney(int amount) {
        money = money + amount;
        ((MyWorld) getWorld()).updateMoney();
    }
    
    public void removeMoney(int amount) {
        money = money - amount;
        ((MyWorld) getWorld()).updateMoney();
    }
    
    public int getMoney() {
        return money;
    }
}
