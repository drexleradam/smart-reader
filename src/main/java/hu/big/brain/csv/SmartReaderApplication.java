package hu.big.brain.csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SmartReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartReaderApplication.class, args);
    }

}
