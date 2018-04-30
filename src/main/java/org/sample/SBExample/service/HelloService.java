package org.sample.SBExample.service;

import org.sample.SBExample.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    HelloService() {
        logger.info("HelloService started");
    }

    @Value("${name:unknown}")
    private String name;

    public String getMessage() { return "Hello " + name; }
}
