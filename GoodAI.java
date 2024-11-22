import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NiceAI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodAI extends AICar
{
    /**
     * Act - do whatever the NiceAI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int i = 0;
    private boolean wallWasLeft;
    private boolean wallWasWasLeft;
    private boolean wallWasRight;
    private boolean wallWasWasRight;
    
    public void act()
    {
        if (i % 4 == 0) {
            System.out.println(wallOnRight());
            followWallRight();
        }
        i++;
        super.act();
    }
    
    public void followWallRight() {
        if (wallWasLeft && !wallOnLeft()) {
            turnLeft();
            wallWasLeft = wallOnLeft();
            wallWasRight = wallOnRight();
            return;
        }
        if (wallWasRight && !wallOnRight()) {
            turnRight();
            wallWasLeft = wallOnLeft();
            wallWasRight = wallOnRight();
            return;
        }
        wallWasLeft = wallOnLeft();
        wallWasRight = wallOnRight();
        if (frontIsClear()) {
            move();
        } else if (!wallOnLeft()) {
            turnLeft();
        } else {
            turnRight();
        }
    }
}
