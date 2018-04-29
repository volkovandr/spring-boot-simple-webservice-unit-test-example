package org.sample.SBExample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    HelloService() {
        System.out.println("I'm HelloService and I'm starting!!!");
    }
    @Value("${name:unknown}")
    private String name;

    public String getMessage() { return "Hello " + name; }
}
