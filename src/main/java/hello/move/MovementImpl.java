package hello.move;

/**
 * Created by andrewevans on 24/07/2017.
 */
public abstract class MovementImpl implements Movement {
    public synchronized void move() throws InterruptedException{
        System.out.println("move the Raspberry Pi");
    }
}
