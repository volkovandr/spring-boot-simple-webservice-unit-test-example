package org.sample.SBExample.scheduled;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.SBExample.service.CounterService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.yml")
public class CounterIncrementorTest {
    @MockBean
    CounterService counterService;

    @Test
    public void incrementor_should_call_increment_method() {
        CounterIncrementor counterIncrementor = new CounterIncrementor(counterService);
        counterIncrementor.incrementCounter();
        verify(counterService, times(1)).increment();
    }
}
