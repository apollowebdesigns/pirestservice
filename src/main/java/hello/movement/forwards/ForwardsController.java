package hello.movement.forwards;

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
public class ForwardsController {
    private MovementFactory movementFactory = MovementFactory.getInstance();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private Movement forwards = movementFactory.getDirection(Direction.FORWARDS);

    public Movement getForwards() {
        assert forwards != null : forwards = movementFactory.getDirection(Direction.FORWARDS);
        return forwards;
    }

    @CrossOrigin
    @RequestMapping("/hits/forwards")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        getForwards().move();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}
