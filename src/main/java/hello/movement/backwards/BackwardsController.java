package hello.movement.backwards;

import hello.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by andrewevans on 04/06/2017.
 */
@RestController
public class BackwardsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/backwards")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        Backwards backwards = new Backwards();
        backwards.moveBackwards();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}