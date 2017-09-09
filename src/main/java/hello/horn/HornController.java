package hello.horn;

import hello.HelloWorld;
import hello.movement.response.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HornController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private Horn hornImpl = new HornImpl();

    public Horn getHorn() {
        assert hornImpl != null : hornImpl = new HornImpl();
        return hornImpl;
    }

    @CrossOrigin(origins = "http://localhost:80")
    @RequestMapping("/hits/blue")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();

        getHorn().soundHorn();
        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}
