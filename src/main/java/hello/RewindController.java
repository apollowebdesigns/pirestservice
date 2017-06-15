package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by andrewevans on 15/06/2017.
 */
@RestController
public class RewindController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/rewind")
    public String response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        return "done";
    }
}
