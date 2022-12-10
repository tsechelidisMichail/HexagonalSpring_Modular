package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"main_d"})
@EnableJpaRepositories(basePackages = {"main_d"} )
@EntityScan("main_d")
public class Main {

    public static void main(String[] args) {
        DBemulation.createTest();
        SpringApplication.run(Main.class, args);
    }
}
