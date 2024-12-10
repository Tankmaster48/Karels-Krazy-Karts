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
    private int laps = 0;
    private boolean won;
    private boolean sound;
    private MyWorld world;
    private int crashTime = 260;
    private GreenfootSound crashSound = new GreenfootSound("crash.wav");
    
    public void act()
    {
        if (world == null) {
            world = (MyWorld) getWorld();
        }
        if (crashTimer > 0) {
            crash();
        }
        
        if (won && crashTimer == 0) {
            ((MyWorld) getWorld()).end();
        }
    }
    
    public void move() {
        if (world == null || world.getFreeze()) return;
        if (crashTimer == 0) {
            if (!frontIsClear()) {
                checkIntersection();
            }
            else {
                // if (sound) (new GreenfootSound("enginerev.wav")).play();
                move(64);
            }
        }
    }
    
    public void pickBeeper() {
        if (crashTimer != 0) {
            return;
        }
        Beeper beep = (Beeper) getOneIntersectingObject(Beeper.class);
        if (beep != null) 
            beep.pick((PlayerCar) this);
    }
    
    public void crash() {
        if (crashTimer == crashTime) {
            move(16);
        }
        else if (crashTimer == crashTime - 19) {
            turn(180);
            move(16);
            turn(180);
            crashSound.play();
        }
        else if (crashTimer < crashTime - 19) {
            turn(30);
        }
        crashTimer--;
    }
    
    public void turnLeft() {
        if (crashTimer == 0 && !((MyWorld) getWorld()).getFreeze()) {
            if (sound) (new GreenfootSound("tirescreech.wav")).play();
            turn(270);
        }
    }
    
    public boolean frontIsClear() {
        boolean wasFirstFinish = getOneIntersectingObject(FirstFinishLine.class) != null;
        boolean wasFinish = getOneIntersectingObject(FinishLine.class) != null;
        boolean ans;
        move(30); // move off of the current grid
        ans = getOneIntersectingObject(Wall.class) == null && getOneIntersectingObject(Car.class) == null; // null checks if any class is intersecting
        boolean frontFirstFinish = getOneIntersectingObject(FirstFinishLine.class) != null;
        boolean frontFinish = getOneIntersectingObject(FinishLine.class) != null;
        turn(180);
        move(30);
        turn(180);
        
        // finishline should add lap if crossing, remove lap if backward
        if (wasFirstFinish && frontFinish) {
            laps++;
            lap();
        }
        if (wasFinish && frontFirstFinish) {
            laps--;
        }
        return ans;
    }
    
    public void lap() {
        if (laps == world.getLaps()) {
            crashTimer = 240;
            won = true;
            ((MyWorld) getWorld()).win(this);
        }   
    }
    
    public void checkIntersection() {
        move(30); // move off of the current grid
            // if we have entered into this block, we are currently intersecting something.
        if (isTouching(Wall.class)) {
            crashTimer = 260;
        }
        else if (isTouching(Car.class)) {
            playerCrash();
        }
        turn(180);
        move(30);
        turn(180);
    }
    
    public void playerCrash() {
        Car frontCar = (Car) getOneIntersectingObject(Car.class);
        if (frontCar.getCrash() == 0 && crashTimer == 0) { // we will ignore crashing into cars that are already crashing
            frontCar.setRotation(this.getRotation());
            if (frontCar.frontIsClear()) {
                frontCar.move(64);
            }
            frontCar.setCrash(240);
            crashTimer = 260;
        }
    }
    
    public Actor frontCar() {
        move(30);
        Actor car = getOneIntersectingObject(Car.class);
        turn(180);
        move(30);
        turn(180);
        return car;
    }
    
    public void setCrash(int crash) {
        crashTimer = crash / 260 * crashTime;
    }
    
    public void setCrashTime(int time) {
        crashTime = time;
    }
    
    public void setSound(boolean sound) {
        this.sound = sound;
    }
    
    public int getCrash() {
        return crashTimer;
    }
    
    public void turnAround() {
        turn(180);
    }
    
    public void turnRight() {
        turn(90);
    }
}