package de.techdev.jaxenter;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 * @author Moritz Schulze
 */
@Component
@RepositoryEventHandler(Person.class)
public class PersonEventHandler {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeSave
    public void checkPUTAuthority(Person person) {
        // only security check
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeCreate
    public void checkPOSTAuthority(Person person) {
        // only security check
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeDelete
    public void checkDELETEAuthority(Person person) {
        // only security check
    }
}
