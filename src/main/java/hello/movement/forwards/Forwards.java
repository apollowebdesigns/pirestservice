package hello.movement.forwards;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.GpioControllerImpl;
import hello.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewevans on 06/06/2017.
 */
public class Forwards {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private String database;

    protected void finalize() {
        System.out.println("last cleanup!");
    }
    public void moveForwards() throws InterruptedException, FileNotFoundException, IOException {
        FileOutputStream fileOut =
        new FileOutputStream("/temp/employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        //String commands
        System.out.println("testing spring ioc");
        System.out.println(database);

        //must not be static!!!!
        final GpioController gpio = new GpioControllerImpl();

        final GpioPinDigitalOutput motor1A = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor1B = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor1E = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.LOW);

        final GpioPinDigitalOutput motor2A = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor2B = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput motor2E = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        motor1A.high();
        motor1B.low();
        motor1E.high();

        motor2A.high();
        motor2B.low();
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


        System.out.println("before thread");
        Thread.sleep(5000);
        System.out.println("after thread");
        System.out.println(Thread.activeCount());
        System.out.println("before second shutdown options");
        //shut down the pins for reuse
        System.out.println("has the gpio shutdown correctly?");
        System.out.println(gpio.isShutdown());
        System.out.println("shutting down");
        gpio.shutdown();
        System.out.println("post shutdown");
        System.out.println(gpio.isShutdown());
        for (GpioPinDigitalOutput pin : pins) gpio.unprovisionPin(pin);
        System.out.println("should be off now!");
        System.gc();
    }
}
