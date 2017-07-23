package hello.move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by andrewevans on 23/07/2017.
 */
public interface Movement {

    /**
     * A default method for moveing the Raspberry Pi
     * @throws InterruptedException
     */
    default void move() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Movement.class);
        logger.info("no GPIO movement implementation added to class yet");
    };
}
