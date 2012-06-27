package se.ebjork.dao;

import java.util.List;

import se.ebjork.domain.Person;

/**
 * Person DAO interface.
 */
public interface PersonDao extends AbstractDao<Person, Long> {

    /**
     * Find persons by first name.
     * @param firstName First name
     * @return Person entity
     */
    List<Person> findByFirstName(String firstName);

    /**
     * Find persons by last name.
     * @param lastName Last name
     * @return Person entity
     */
    List<Person> findByLastName(String lastName);

}
