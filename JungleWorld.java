import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JungleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JungleWorld extends World
{

    /**
     * Constructor for objects of class JungleWorld.
     * 
     */
    public JungleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Tree tree = new Tree();
        addObject(tree, 52, 70);
        Tree tree2 = new Tree();
        addObject(tree2, 246, 205);
        Tree tree3 = new Tree();
        addObject(tree3, 455, 342);
        Tree tree4 = new Tree();
        addObject(tree4, 390, 69);
        Tree tree5 = new Tree();
        addObject(tree5, 547, 170);
        Tree tree6 = new Tree();
        addObject(tree6, 99, 333);
        Rock rock = new Rock();
        addObject(rock, 102, 185);
        Rock rock2 = new Rock();
        addObject(rock2, 417, 228);
        Bananas bananas = new Bananas();
        addObject(bananas, 83, 80);
        Bananas bananas2 = new Bananas();
        addObject(bananas2, 421, 84);
        Bananas bananas3 = new Bananas();
        addObject(bananas3, 272, 237);
        Bananas bananas4 = new Bananas();
        addObject(bananas4, 484, 339);
        Bananas bananas5 = new Bananas();
        addObject(bananas5, 577, 181);
        Bananas bananas6 = new Bananas();
        addObject(bananas6, 129, 348);
        Elephant elephant = new Elephant();
        addObject(elephant, 151, 48);
        Hippo hippo = new Hippo();
        addObject(hippo, 551, 369);
        Lemur lemur = new Lemur();
        addObject(lemur, 44, 362);
        Rock rock3 = new Rock();
        addObject(rock3, 294, 349);
        removeObject(bananas2);
        removeObject(tree4);
        removeObject(tree5);
        removeObject(bananas5);
        removeObject(rock2);
        removeObject(bananas4);
        removeObject(hippo);
        removeObject(tree3);
        removeObject(rock3);
        removeObject(tree2);
        removeObject(bananas3);
        removeObject(bananas6);
        removeObject(tree6);
        removeObject(lemur);
        removeObject(rock);
        removeObject(elephant);
        removeObject(bananas);
        removeObject(tree);
    }
}
