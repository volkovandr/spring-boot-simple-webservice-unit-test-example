package org.sample.SBExample.service;

import org.sample.SBExample.model.Customer;
import org.sample.SBExample.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        logger.info("CustomerService initialized!");
    }

    public void newCustomer(String firstName, String lastName) {
        customerRepository.save(new Customer(firstName, lastName));
        logger.info("Saved a new Customer [" + firstName + " " + lastName + "]");
    }

    public Iterable<Customer> getCustomers() {
        logger.debug("Returning list of all Customers");
        return customerRepository.findAll();
    }
}
