package de.techdev.jaxenter;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Moritz Schulze
 */
@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

}
