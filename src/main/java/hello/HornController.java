package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Created by andrewevans on 04/06/2017.
 */
@RestController
public class HornController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {

        

        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}
