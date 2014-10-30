package de.techdev.jaxenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Just a test service to show dependency injection works.
 *
 * @author Moritz Schulze
 */
@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findPersonsWithFirstNameLikeMo() {
        logger.debug("Foo has been called");
        return personRepository.findByFirstNameLike("%Mo%");
    }
}
