import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartLight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartLight extends GuiActor
{
    /**
     * Act - do whatever the StartLight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int i = 0;
    private GreenfootSound countdownSound = new GreenfootSound("countdown.wav");
    
    public void act()
    {
        i++;
        if (i % 50 == 0) nextSprite(i / 50);
    }
    
    public void nextSprite(int i) {
        countdownSound.play();
        switch (i) {
            case 0:
                break;
            case 1:
                setImage("yellow.png");
                break;
            case 2:
                setImage("green1.png");
                break;
            case 3:
                setImage("green2.png");
                break;
            case 4:
                setImage("green3.png");
                break;
            case 5:
                setImage("green4.png");
                break;
            case 6:
                setImage("green5.png");
                MyWorld world = (MyWorld) getWorld();
                world.setFreeze(false);
                world.startMusic();
                world.removeObject(this);
                break;
        }
    }
}
