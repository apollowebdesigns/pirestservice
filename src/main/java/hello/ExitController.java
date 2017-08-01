package hello;

import hello.web.ControllerResponse;
import hello.movement.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExitController implements ControllerResponse {
    @RequestMapping("/hits/kill")
    public Response response() {
        System.exit(0);
        return new Response(2, "testing testing");
    }
}
