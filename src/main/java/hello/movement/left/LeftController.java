package hello.movement.left;

import hello.movement.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LeftController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/left")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        Left left = new Left();
        left.move();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}