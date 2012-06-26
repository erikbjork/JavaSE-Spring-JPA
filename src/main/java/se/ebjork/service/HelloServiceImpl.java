package se.ebjork.service;

import org.springframework.stereotype.Service;

/**
 * Simple implementation of HelloService interface.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public final String hello() {

        return "Hello";

    }

}
