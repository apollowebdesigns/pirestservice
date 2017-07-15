package hello.movement.left;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.GpioControllerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewevans on 12/06/2017.
 */
public class Left {
    protected void finalize() {
        System.out.println("last cleanup!");
    }

    /**
     * Moves Raspberry Pi left
     * @throws InterruptedException
     */
    public void moveLeft() throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

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


        System.out.println("before thread");
        Thread.sleep(2000);
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
