package se.ebjork.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import se.ebjork.domain.Person;

/**
 * Person DAO.
 */
@Repository
public class PersonDaoImpl extends AbstractDaoImpl<Person, Long> implements PersonDao {

    public PersonDaoImpl() {
        super(Person.class);
    }

    @Override
    public final List<Person> findByFirstName(final String firstName) {
        return getEm().createNamedQuery("Person.findByFirstName", getType()).setParameter("firstName", firstName)
                .getResultList();
    }

    @Override
    public final List<Person> findByLastName(final String lastName) {
        return getEm().createNamedQuery("Person.findByLastName", getType()).setParameter("lastName", lastName)
                .getResultList();
    }

}
