package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "domain_imp")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
