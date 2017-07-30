package hello;

import hello.rewind.Direction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by andrewevans on 15/06/2017.
 */
@RestController
public class RewindController {
    private static final Logger log = LoggerFactory.getLogger(RewindController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/rewind")
    public List<Direction> response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {

        RestTemplate restTemplate = new RestTemplate();
        List<Direction> quote = restTemplate.getForObject("http://localhost:8080/rewind/all", List.class);
        log.info(quote.toString());

        return quote;
    }
}
