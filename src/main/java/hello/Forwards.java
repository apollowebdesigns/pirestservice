package hello;

import com.pi4j.io.gpio.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewevans on 06/06/2017.
 */
public class Forwards {
    public static void moveForwards() {
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

        motor1A.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor1B.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor1E.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        motor2A.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor2B.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        motor2E.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        // set shutdown state for this pin

        System.out.println("--> GPIO state should be: ON");

        motor1A.high();
        motor1B.low();
        motor1E.high();

        motor2A.high();
        motor2B.low();
        motor2E.high();


        try {
            System.out.println("before thread");
            Thread.sleep(5000);
            System.out.println("after thread");
            System.out.println(Thread.activeCount());
        } catch (GpioException e) {
            System.out.println("pi problem");
        } catch (InterruptedException e) {
            System.out.println("interrupted!!!");
        }   finally {
            System.out.println("before second shutdown options");
            //Thread killed
            motor1A.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
            motor1B.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
            motor1E.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

            motor2A.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
            motor2B.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
            motor2E.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

            gpio.shutdown();
            //shut down the pins for reuse
            gpio.unprovisionPin();
            pins.forEach(pin -> gpio.unprovisionPin(pin));
            System.out.println("has the gpio shutdown correctly?");
            System.out.println(gpio.isShutdown());
            gpio.shutdown();
        }
    }
}
