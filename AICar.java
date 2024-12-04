import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AICar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AICar extends Car
{
    /**
     * Act - do whatever the AICar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        super.act();
    }
    
    public boolean wallOnRight() { 
        boolean ans;
        turn(90);
        move(30);
        ans = getOneIntersectingObject(Wall.class) != null;
        turn(180);
        move(30);
        turn(90);
        return ans;
    }
    
    public boolean wallOnLeft() { 
        boolean ans;
        turn(180);
        turn(90);
        move(30);
        ans = getOneIntersectingObject(Wall.class) != null;
        turn(180);
        move(30);
        turn(90);
        turn(180);
        return ans;
    }
    
    public boolean wallInFront() {
        boolean ans;
        move(30);
        ans = getOneIntersectingObject(Wall.class) != null;
        turn(180);
        move(30);
        turn(180);
        return ans;
    }
    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}