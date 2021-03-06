package hello.movement.right;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.GpioControllerImpl;
import hello.move.Movement;
import hello.move.MovementImpl;
import hello.rewind.Direction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Right extends MovementImpl implements Movement {
    Logger logger = LoggerFactory.getLogger(Right.class);

    protected void finalize() {
        logger.info("last cleanup!");
    }

    /**
     * Moves Raspberry Pi right
     * @throws InterruptedException
     */
    public synchronized void move() throws InterruptedException {
        logger.info("<--Pi4J--> GPIO Control Example ... started.");

        //must not be static!!!!
        final GpioController gpio = new GpioControllerImpl();

        final GpioPinDigitalOutput motor1A = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor1B = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor1E = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.LOW);

        final GpioPinDigitalOutput motor2A = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor2B = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor2E = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.LOW);

        logger.info("--> GPIO state should be: ON");

        motor1A.high();
        motor1B.low();
        motor1E.high();

        motor2A.low();
        motor2B.high();
        motor2E.high();

        motor1A.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor1B.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor1E.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        motor2A.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor2B.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor2E.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        List<GpioPinDigitalOutput> pins = new ArrayList<>();

        pins.add(motor1A);
        pins.add(motor1B);
        pins.add(motor1E);
        pins.add(motor2A);
        pins.add(motor2B);
        pins.add(motor2E);

        // set shutdown state for this pin


        logger.info("before thread");
        Thread.sleep(500);
        logger.info("after thread");
        System.out.println(Thread.activeCount());
        logger.info("before second shutdown options");
        //shut down the pins for reuse
        logger.info("has the gpio shutdown correctly?");
        System.out.println(gpio.isShutdown());
        logger.info("shutting down");
        gpio.shutdown();
        logger.info("post shutdown");
        System.out.println(gpio.isShutdown());
        for (GpioPinDigitalOutput pin : pins) gpio.unprovisionPin(pin);
        logger.info("should be off now!");

        //adding opposite direction to database
        RestTemplate restTemplate = new RestTemplate();
        List<Direction> previousRequests = restTemplate.getForObject("http://localhost:8080/rewind/add?time=now&dir=/hits/left", List.class);
        logger.info(previousRequests.toString());

        System.gc();
    }
}
