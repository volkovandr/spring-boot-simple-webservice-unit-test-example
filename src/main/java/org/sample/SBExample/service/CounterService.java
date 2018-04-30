package org.sample.SBExample.service;

import org.sample.SBExample.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private static final Logger logger = LoggerFactory.getLogger(CounterService.class);

    CounterService() {
        logger.info("CounterService started");
        count = 0;
    }

    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
