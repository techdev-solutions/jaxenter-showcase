package de.techdev.jaxenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

import static java.util.Arrays.asList;

/**
 * @author Moritz Schulze
 */
@Configuration
@EnableJpaRepositories
public class PersistenceConfiguration {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    private void addPersons() {
        Person moritz = new Person();
        moritz.setFirstName("Moritz");
        Person monika = new Person();
        monika.setFirstName("Monika");
        personRepository.save(asList(moritz, monika));
    }
}
