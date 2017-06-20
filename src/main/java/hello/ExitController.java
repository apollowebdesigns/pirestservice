package hello;

import hello.interfaces.ControllerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrewevans on 06/06/2017.
 */
@RestController
public class ExitController implements ControllerResponse {
    @RequestMapping("/hits/kill")
    public Response response() {
        System.exit(0);
        return new Response(2, "testing testing");
    }
}
