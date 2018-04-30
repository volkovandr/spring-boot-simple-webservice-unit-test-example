package org.sample.SBExample.web;

import org.sample.SBExample.Application;
import org.sample.SBExample.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private static final Logger logger = LoggerFactory.getLogger(CounterController.class);

    CounterController(CounterService counterService) {
        logger.info("CounterController started");
        this.counterService = counterService;
    }

    private CounterService counterService;

    @RequestMapping(value = "")
    public int get() {
        counterService.increment();
        return counterService.getCount();
    }
}
