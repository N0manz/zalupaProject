package project.zalupa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ZalupaApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ZalupaApplication.class, args);
    }
}

