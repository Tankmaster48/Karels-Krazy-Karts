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
    private boolean crossingFinish = false;
    private int laps = 0;
    
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
        if (frontIsClear()) {
            Car carCrash = (Car) frontCar();
            if (carCrash == null) {
                move(64);
            } else {
                int enemyDirection = carCrash.getRotation();
                if (carCrash.getCrash() == 0) {
                    crashTimer = 260;
                    carCrash.setRotation(this.getRotation());
                    carCrash.move(64); // later make go in the same directio nhit
                    carCrash.setCrash(260);
                    carCrash.setRotation(enemyDirection);
                } else {
                    move(64);
                }
            }
        } else {
            crashTimer = 250;
        }
    }
    
    public void pickBeeper() {
        Beeper beep = (Beeper) getOneIntersectingObject(Beeper.class);
        if (beep != null) beep.pick((PlayerCar) this);
    }
    
    public void crash() {
        if (crashTimer < 241) {
            turn(30);
        } else if (crashTimer == 260) {
            move(16);
        } else if (crashTimer == 251) {
            turn(180);
            move(16);
            turn(180);
        } else if (crashTimer == 250) {
            move(4);
        } else if (crashTimer == 241) {
            turn(180);
            move(4);
            turn(180);
        }
        crashTimer--;
    }
    
    public void checkWin() {
        MyWorld world = (MyWorld) getWorld();
        if (world.getLaps() == laps) {
            // win the game
        }
    }
    
    public void turnLeft() {
        if (crashTimer > 0) {
            return;
        }
        
        turn(270);
    }
    
    public boolean frontIsClear() {
        if (isTouching(FinishLine.class)) {
            crossingFinish = false;
            move(10);
            if (isTouching(FirstFinishLine.class)) {
                turn(180);
                move(10);
                turn(180);
                return false;
            } else {
                turn(180);
                move(10);
                turn(180);
                return true;
            }
        }
        move(10);
        if (isTouching(FinishLine.class)) {
            if (crossingFinish) {
                turn(180);
                move(10);
                turn(180);
                laps++;
                return true;
            } else {
                turn(180);
                move(10);
                turn(180);
                return false;
            }
        } else if (isTouching(VerticalWall.class) || isTouching(HorizontalWall.class)){
            turn(180);
            move(10);
            turn(180);
            return false;
        }
        turn(180);
        move(10);
        turn(180);
        return true;
    }
    
    public Actor frontCar() {
        move(10);
        Actor car = getOneIntersectingObject(Car.class);
        turn(180);
        move(10);
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
