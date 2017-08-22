package justanorg.bitbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BitBrokerApp {

    public static void main(String[] args) {
        SpringApplication.run(BitBrokerApp.class, args);
    }

}
