package se.ebjork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import se.ebjork.dao.PersonDao;
import se.ebjork.domain.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonDao personDao;

    @InjectMocks
    private final PersonService personService = new PersonServiceImpl();

    @Test
    public void testAddPerson() {
        personService.addPerson("John", "Doe");

        final Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        // Verify that the save method on PersonDao gets called with the right name.
        Mockito.verify(personDao).save(person);
    }

    @Test
    public void testListPersons() {
        personService.listPersons();

        // Verify that the findAll method on PersonDao gets called.
        Mockito.verify(personDao).findAll();
    }
}
