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
    private boolean finishing = false;
    private int laps = 0;
    
    public void act()
    {
        if (crashTimer > 0) {
            crash();
        }
    }
    
    public void move() {
        if (crashTimer == 0) {
            if (!frontIsClear()) {
                checkIntersection();
            }
            else {
                move(64);
            }
        }
    }
    
    public void pickBeeper() {
        Beeper beep = (Beeper) getOneIntersectingObject(Beeper.class);
        if (beep != null) beep.pick((PlayerCar) this);
    }
    
    public void crash() {
        if (crashTimer == 260) {
            move(16);
        }
        else if (crashTimer == 241) {
            turn(180);
            move(16);
            turn(180);
        }
        else if (crashTimer < 241) {
            turn(30);
        }
        crashTimer--;
    }
    
    public void checkWin() {
        MyWorld world = (MyWorld) getWorld();
        if (world.getLaps() == laps) {
            return;
        }
    }
    
    public void turnLeft() {
        if (crashTimer == 0 && !finishing) {
            turn(270);
        }
    }
    
    public boolean frontIsClear() {
        boolean ans;
        move(30); // move off of the current grid
        ans = getOneIntersectingObject(null) == null; // null checks if any class is intersecting
        turn(180);
        move(30);
        turn(180);
        
        // if we are not touching anything anymore (ans = false) but we are currently finishing,
        // we must have passed through the final finish line and done a lap.
        if (ans == false && finishing) {
            finishing = false;
            laps++;
        }
        return ans;
    }
    
    public void checkIntersection() {
        move(30); // move off of the current grid
        if (getOneIntersectingObject(null) != null) {
            // if we have entered into this block, we are currently intersecting something.
            if (isTouching(FirstFinishLine.class)) {
                finishing = true;
                move(64);
            }
            else if (isTouching(Wall.class)) {
                crashTimer = 260;
            }
            else if (isTouching(Car.class)) {
                System.out.println("hi");
                playerCrash();
            }
        }
        turn(180);
        move(30);
        turn(180);
    }
    
    public void playerCrash() {
        Car frontCar = (Car) getOneIntersectingObject(Car.class);
        if (frontCar.getCrash() == 0 && crashTimer == 0) { // we will ignore crashing into cars that are already crashing
            frontCar.setRotation(this.getRotation());
            frontCar.move(64);
            frontCar.setCrash(260);
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
        crashTimer = crash;
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