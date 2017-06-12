package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//GPIO imports

/**
 * Created by andrewevans on 04/06/2017.
 */
@RestController
public class ForwardsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/forwards")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        Forwards forwards = new Forwards();
        forwards.moveForwards();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}
