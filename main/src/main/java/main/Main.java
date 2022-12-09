package main;

import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "domain_imp")
public class Main {
    @Autowired
    private Account acc;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
