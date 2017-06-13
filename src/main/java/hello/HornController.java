package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by andrewevans on 04/06/2017.
 */
@RestController
public class HornController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/motor")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        Horn horn = new Horn();
        horn.soundHorn();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}
