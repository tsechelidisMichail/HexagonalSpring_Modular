package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"domain_imp","web","persistence"})
@EntityScan("persistence")
public class Main {

    public static void main(String[] args) {
        DBemulation.createTest();
        SpringApplication.run(Main.class, args);
    }
}
