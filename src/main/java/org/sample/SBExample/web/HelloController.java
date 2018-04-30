package org.sample.SBExample.web;

import org.sample.SBExample.Application;
import org.sample.SBExample.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private HelloService helloService;

    HelloController(HelloService helloService) {
        logger.info("HelloController started");
        this.helloService = helloService;
    }

    @RequestMapping(value = "/hello")
    public String get() {
        return helloService.getMessage();
    }
}
