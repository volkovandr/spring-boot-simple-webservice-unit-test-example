package org.sample.SBExample.web;

import org.sample.SBExample.service.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {

    CounterController(CounterService counterService) {
        System.out.println("Hello, I'm the CounterController and I'm starting now!");
        this.counterService = counterService;
    }

    private CounterService counterService;

    @RequestMapping(value = "")
    public int get() {
        counterService.increment();
        return counterService.getCount();
    }
}
