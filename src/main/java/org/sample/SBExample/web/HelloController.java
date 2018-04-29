package org.sample.SBExample.web;

import org.sample.SBExample.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloService helloService;

    HelloController(HelloService helloService) {
        System.out.println("I'm HelloController and I am starting!");
        this.helloService = helloService;
    }

    @RequestMapping(value = "/hello")
    public String get() {
        return helloService.getMessage();
    }
}
