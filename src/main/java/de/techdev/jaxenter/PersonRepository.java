package de.techdev.jaxenter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Moritz Schulze
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstNameLike(String firstName);

}
