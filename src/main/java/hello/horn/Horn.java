package hello.horn;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.GpioControllerImpl;

/**
 * Created by andrewevans on 13/06/2017.
 */
public class Horn {
    protected void finalize() {
        System.out.println("last cleanup!");
    }
    public void soundHorn() throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        //must not be static!!!!
        final GpioController gpio = new GpioControllerImpl();

        final GpioPinDigitalOutput horn = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        horn.high();

        horn.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        // set shutdown state for this pin


        System.out.println("before thread");
        Thread.sleep(1000);
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
        gpio.unprovisionPin(horn);
        System.out.println("should be off now!");
        System.gc();
    }
}
