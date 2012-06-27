package se.ebjork.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import se.ebjork.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@Transactional
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Before
    public void setUp() {
        final Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        personDao.save(person1);

        final Person person2 = new Person();
        person2.setFirstName("Ann");
        person2.setLastName("Lane");
        personDao.save(person2);
    }

    @Test
    public void testCount() {
        Assert.assertEquals(2, personDao.count());
    }

    @Test
    public void testFindAll() {
        final List<Person> list = personDao.findAll();

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testFindByFirstName() {
        final List<Person> list = personDao.findByFirstName("John");

        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Doe", list.get(0).getLastName());
    }

    @Test
    public void testFindByLastName() {
        final List<Person> list = personDao.findByLastName("Lane");

        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Ann", list.get(0).getFirstName());
    }

}
