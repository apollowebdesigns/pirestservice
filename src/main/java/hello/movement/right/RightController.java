package hello.movement.right;

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
public class RightController {
    private MovementFactory movementFactory = MovementFactory.getInstance();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private Movement right = movementFactory.getDirection(Direction.RIGHT);

    public Movement getRight() {
        assert right != null : right = movementFactory.getDirection(Direction.RIGHT);
        return right;
    }

    @CrossOrigin(origins = "http://localhost:80")
    @RequestMapping("/hits/right")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        getRight().move();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}