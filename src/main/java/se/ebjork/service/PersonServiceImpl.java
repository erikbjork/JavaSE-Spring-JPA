package se.ebjork.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.ebjork.dao.PersonDao;
import se.ebjork.domain.Person;

/**
 * Implementation of PersonService.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonDao personDao;

    @Override
    public final void addPerson(final String firstName, final String lastName) {
        logger.debug("Adding a person.");

        final Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        personDao.save(person);
        logger.info("Added person: {} {}", firstName, lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public final List<String> listPersons() {
        logger.debug("Listing persons.");

        final List<Person> personList = personDao.findAll();

        final List<String> result = new ArrayList<String>();
        for (final Person p : personList) {
            result.add(p.getFirstName() + " " + p.getLastName());
        }

        return result;
    }

}
