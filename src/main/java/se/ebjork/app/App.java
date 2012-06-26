package se.ebjork.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import se.ebjork.service.HelloService;

@Component
public class App {

    @Autowired
    private HelloService helloService;

    public App() {

    }

    public static void main(final String[] args) {

        final ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        final App app = context.getBean(App.class);
        app.useHelloService();

    }

    public void useHelloService() {

        System.out.println(helloService.hello());

    }

}
