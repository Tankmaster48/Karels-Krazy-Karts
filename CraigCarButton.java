import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CraigCarButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CraigCarButton extends Button
{
    /**
     * Act - do whatever the CraigCarButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car car) {
        car.setImage("craigcar.png");
        super.sound();
    }
}
