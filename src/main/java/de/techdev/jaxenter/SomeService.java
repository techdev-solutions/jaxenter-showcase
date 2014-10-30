package de.techdev.jaxenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Just a test service to show dependency injection works.
 *
 * @author Moritz Schulze
 */
@Service
public class SomeService {

    private Logger logger = LoggerFactory.getLogger(SomeService.class);

    public String foo() {
        logger.debug("Foo has been called");
        return "bar";
    }
}
