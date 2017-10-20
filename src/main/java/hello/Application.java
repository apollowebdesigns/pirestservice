package hello;

import hello.email.EmailIp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        InetAddress ip = null;
        String hostname = "";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            String from = "raspberrypinoreply123@gmail.com";
            String pass = "RideThePi1993";
            String[] to = { "andrewevans0@outlook.com" }; // list of recipient email addresses
            String subject = "Java send mail example";
            String body = "Welcome to Raspberry Pi! Your IP address is " + ip.getHostName();

            EmailIp.sendFromGMail(from, pass, to, subject, body);
        } catch (UnknownHostException e) {
            log.error(e.toString());
        } catch (Exception e) {
            System.out.println("different exception");
            log.error(e.toString());
        } finally {
            SpringApplication.run(Application.class, args);
        }
    }
}