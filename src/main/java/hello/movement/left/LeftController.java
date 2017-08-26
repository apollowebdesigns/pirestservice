package hello.movement.left;

import hello.move.Direction;
import hello.move.Movement;
import hello.move.MovementFactory;
import hello.movement.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LeftController {
    private MovementFactory movementFactory = MovementFactory.getInstance();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private Movement left = movementFactory.getDirection(Direction.LEFT);

    public Movement getLeft() {
        assert left != null : left = movementFactory.getDirection(Direction.LEFT);
        return left;
    }

    @RequestMapping("/hits/left")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        getLeft().move();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}