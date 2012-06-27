package se.ebjork.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import se.ebjork.service.PersonService;

@Component
public class App {

    @Autowired
    private PersonService personService;

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        final App app = context.getBean(App.class);

        app.printPersons();
        System.out.println("Adding persons...");
        app.addPersons();
        app.printPersons();
    }

    public void addPersons() {
        personService.addPerson("John", "Doe");
        personService.addPerson("Ann", "Lane");
    }

    public void printPersons() {
        final List<String> persons = personService.listPersons();

        if (persons.size() == 0) {
            System.out.println("There are no persons.");
            return;
        }

        System.out.println("Persons:");
        for (final String person : persons) {
            System.out.println(person);
        }
    }

}
