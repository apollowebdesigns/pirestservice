package hello.rewind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RewindController {
    private static final Logger log = LoggerFactory.getLogger(RewindController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private List<LinkedHashMap> previousRequests;

    public List<LinkedHashMap> getPreviousRequests() {
        RestTemplate restTemplate = new RestTemplate();
        previousRequests = restTemplate.getForObject("http://localhost:8080/rewind/all", List.class);
        return previousRequests;
    }

    private Object resetRewindRequests;

    public Object getResetRewindRequests() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8080/rewind/clear", Object.class);
        return resetRewindRequests;
    }

    @RequestMapping("/hits/rewind")
    public List<LinkedHashMap> response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> previousRequests = getPreviousRequests();

        for (int i = previousRequests.size() - 1; i >= 0; i--) {
            LinkedHashMap request = previousRequests.get(i);
            log.debug("direction");
            log.debug(request.get("direction").toString());
            String requested = "http://localhost" + request.get("direction");
            restTemplate.getForObject(requested, Object.class);
        }

        getResetRewindRequests();

        return previousRequests;
    }
}
