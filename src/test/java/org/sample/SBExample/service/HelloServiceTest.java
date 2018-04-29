package org.sample.SBExample.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.yml")
public class HelloServiceTest {

    @TestConfiguration
    static class HelloServiceConfiguration {
        @Bean
        public HelloService helloService() {
            return new HelloService();
        }
    }

    @Autowired
    HelloService helloService;

    @Test
    public void hello_service_returns_greeting_message() {
        String messageFromService = helloService.getMessage();
        String expectedMessage = "Hello Tester";
        assertThat(messageFromService, equalTo(expectedMessage));
    }

}
