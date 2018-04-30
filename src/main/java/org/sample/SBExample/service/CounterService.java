package org.sample.SBExample.service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

    CounterService() {
        System.out.println("Hello! I'm the CounterService and I'm starting now!");
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
