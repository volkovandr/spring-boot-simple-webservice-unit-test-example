package org.sample.SBExample.scheduled;

import org.sample.SBExample.service.CounterService;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CounterIncrementor {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CounterIncrementor.class);

    private CounterService counterService;

    CounterIncrementor(CounterService counterService) {
        this.counterService = counterService;
        logger.info("CounterIncrementor started");
    }

    @Scheduled(fixedRate = 1000)
    public void incrementCounter() {
        counterService.increment();
        logger.debug("Incremented the counter");
    }
}
