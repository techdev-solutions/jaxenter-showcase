package de.techdev.jaxenter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * @author Moritz Schulze
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<Person> findAll(Pageable pageable);

    @Override
    @PostAuthorize("returnObject.firstName == principal.username or hasRole('ROLE_ADMIN')")
    Person findOne(Long aLong);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Person> findByFirstNameLike(@Param("firstName") String firstName);

    @RestResource(exported = false)
    Person findByFirstNameEquals(String firstName);
}
