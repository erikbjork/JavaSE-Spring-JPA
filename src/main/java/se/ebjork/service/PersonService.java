package se.ebjork.service;

import java.util.List;

/**
 * Simple service handling persons.
 */
public interface PersonService {

    /**
     * Add a person.
     * @param firstName First name
     * @param lastName Last name
     */
    void addPerson(String firstName, String lastName);

    /**
     * List persons.
     * @return List of persons
     */
    List<String> listPersons();

}
