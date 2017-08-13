package hello.orders;

import hello.movement.response.Response;
import hello.rewind.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RightOrder {

    @RequestMapping("/hits/rightorder")
    public Response response() {
        RestTemplate restTemplate = new RestTemplate();
        List<Direction> previousRequests = restTemplate.getForObject("http://localhost:9991/orders/add?time=now&dir=/hits/right", List.class);
        return new Response();
    }
}
