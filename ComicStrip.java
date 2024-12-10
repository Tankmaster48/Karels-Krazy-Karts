import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ComicStrip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComicStrip extends GuiActor
{
    /**
     * Act - do whatever the ComicStrip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int pageNum = 1;
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            pageNum++;
            if (pageNum < 13) {
                setImage("pg" + Integer.toString(pageNum) + ".png");
            }
            else {
                ((MyWorld) getWorld()).endComic();
            }
        }
    }
}
