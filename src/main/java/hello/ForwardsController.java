package hello;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

//GPIO imports

/**
 * Created by andrewevans on 04/06/2017.
 */
@RestController
public class ForwardsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hits/forwards")
    public Response response(@RequestParam(value="name", defaultValue="World") String name) throws InterruptedException {

        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput motor1A = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.HIGH);
        final GpioPinDigitalOutput motor1B = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.HIGH);
        final GpioPinDigitalOutput motor1E = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.HIGH);

        final GpioPinDigitalOutput motor2A = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.HIGH);
        final GpioPinDigitalOutput motor2B = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.HIGH);
        final GpioPinDigitalOutput motor2E = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.HIGH);

        List<GpioPinDigitalOutput> pins = new ArrayList<>();

        pins.add(motor1A);
        pins.add(motor1B);
        pins.add(motor1E);
        pins.add(motor2A);
        pins.add(motor2B);
        pins.add(motor2E);

        // set shutdown state for this pin
        motor1A.setShutdownOptions(true, PinState.LOW);
        motor1B.setShutdownOptions(true, PinState.LOW);
        motor1E.setShutdownOptions(true, PinState.LOW);

        motor2A.setShutdownOptions(true, PinState.LOW);
        motor2B.setShutdownOptions(true, PinState.LOW);
        motor2E.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        motor1A.high();
        motor1B.low();
        motor1E.high();

        motor2A.high();
        motor2B.low();
        motor2E.high();

        Thread.sleep(5000);

        gpio.shutdown();
        //shut down the pins for reuse
        for (GpioPinDigitalOutput pin : pins) gpio.unprovisionPin(pin);

        System.out.println("Exiting ControlGpioExample");


        return new Response(counter.incrementAndGet(),
                String.format(template, name));
    }
}
