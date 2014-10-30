package de.techdev.jaxenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Moritz Schulze
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private SomeService someService;

    @Override
    public void run(String... args) throws Exception {
        String foo = someService.foo();
        logger.info("SomeService returned {}", foo);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
