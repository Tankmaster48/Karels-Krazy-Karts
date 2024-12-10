import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JoshuaCarButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JoshuaCarButton extends Button
{
    /**
     * Act - do whatever the JoshuaCarButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car car) {
        car.setImage("joshuacar.png");
    }
}
