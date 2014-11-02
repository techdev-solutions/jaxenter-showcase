package de.techdev.jaxenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Moritz Schulze
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstNameLike(@Param("firstName") String firstName);

}
