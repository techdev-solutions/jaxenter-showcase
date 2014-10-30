package de.techdev.jaxenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Moritz Schulze
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        List<Person> person = personService.findPersonsWithFirstNameLikeMo();
        logger.info("SomeService returned {}", person);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
