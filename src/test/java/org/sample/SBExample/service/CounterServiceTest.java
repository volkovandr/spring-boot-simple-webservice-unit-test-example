package org.sample.SBExample.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CounterServiceTest {

    @TestConfiguration
    static class CounterServiceConfiguration {
        @Bean
        public CounterService counterService() {
            return new CounterService();
        }
    }

    @Autowired
    private CounterService counterService;

    @Test
    public void counterService_counts_calls_to_increment() {
        for(int i = 0; i < 3; i++)
            counterService.increment();
        assertThat(counterService.getCount(), equalTo(3));
    }
}
