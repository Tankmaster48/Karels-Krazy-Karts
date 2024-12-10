import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LiweiCarButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LiweiCarButton extends Button
{
    /**
     * Act - do whatever the LiweiCarButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void pick(Car car) {
        car.setImage("liweicar.png");
        super.sound();
    }
}
