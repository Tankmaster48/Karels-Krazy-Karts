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
    // GreenfootSound horn = new GreenfootSound("horn.wav");
    private int crashTimer = 0;
    
    public void act()
    {
        if (crashTimer > 0) {
            crash();
        }
    }
    
    public void move() {
        if (crashTimer > 0) {
            return;
        }
        move(64);
        // horn.play();
        if (isTouching(VerticalWall.class)) {
            turn(180);
            move(64);
            turn(180);
            crashTimer = 250;
        }
    }
    
    public void crash() {
        if (crashTimer < 241) {
            turn(30);
        } else if (crashTimer == 250) {
            move(4);
        } else if (crashTimer == 241) {
            turn(180);
            move(4);
            turn(180);
        }
        crashTimer--;
    }
    
    public void turnLeft() {
        turn(270);
    }
}
