package hello.move;

/**
 * Created by andrewevans on 24/07/2017.
 */
public abstract class MovementImpl implements Movement {

    /**
     * Moves Raspberry Pi in a direction
     * @throws InterruptedException
     */
    public synchronized void move() throws InterruptedException{
        System.out.println("move the Raspberry Pi");
    }
}
