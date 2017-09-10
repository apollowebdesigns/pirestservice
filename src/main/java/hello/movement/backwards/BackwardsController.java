package hello.movement.backwards;

import hello.move.Direction;
import hello.move.Movement;
import hello.move.MovementFactory;
import hello.movement.response.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BackwardsController {
    private MovementFactory movementFactory = MovementFactory.getInstance();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private Movement backwards = movementFactory.getDirection(Direction.BACKWARDS);

    public Movement getBackwards() {
        assert backwards != null : backwards = movementFactory.getDirection(Direction.BACKWARDS);
        return backwards;
    }

    /**
     * Function for the controller to move Raspberry Pi backwards.
     * @param name - used as a default placeholder
     * @return response - used to confirm request has been successful.
     * @throws InterruptedException
     */
    @CrossOrigin
    @RequestMapping("/hits/backwards")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        getBackwards().move();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}