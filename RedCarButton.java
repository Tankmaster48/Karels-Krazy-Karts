import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedCarButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedCarButton extends Button
{
    /**
     * Act - do whatever the RedCarButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car car) {
        car.setImage("raymondcar.png");
        super.sound();
    }
}
