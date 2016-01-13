package thymeleaf.spring4.service;

import org.springframework.stereotype.Service;

/**
 * Simple Service
 */
@Service
public class MyService {

    public String sayHello() {
        return "Hello, I'm a method in a spring bean";
    }
}
