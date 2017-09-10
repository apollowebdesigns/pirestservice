package hello.executeorders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ExecuteOrdersController {
    private static final Logger log = LoggerFactory.getLogger(ExecuteOrdersController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin
    @RequestMapping("/hits/execute")
    public List<LinkedHashMap> response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> previousRequests = restTemplate.getForObject("http://localhost:9991/orders/all", List.class);


        for (LinkedHashMap request : previousRequests) {
            log.debug("direction of order");
            log.debug(request.get("direction").toString());
            String requested = "http://localhost" + request.get("direction");
            restTemplate.getForObject(requested, Object.class);
        }

        restTemplate.getForObject("http://localhost:8080/orders/clear", Object.class);
        new RestTemplate().getForObject("http://localhost:8080/rewind/clear", Object.class);
        return previousRequests;
    }
}
