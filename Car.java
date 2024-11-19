import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author Craig Gu
 * @version 11/15/2024
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound horn = new GreenfootSound("horn.wav");
    
    public void act()
    {
        // horn.play();
    }
    
    public void move() {
        super.move(64);
        horn.play();
    }
    
    public void turnLeft() {
        turn(270);
    }
}
