package hello.movement.forwards;

import hello.move.Movement;
import hello.move.MovementFactory;
import hello.movement.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ForwardsController {
    private MovementFactory movementFactory = new MovementFactory();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/forwards")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {

        Movement forwards = movementFactory.getDirection("Forwards");
        forwards.move();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}
