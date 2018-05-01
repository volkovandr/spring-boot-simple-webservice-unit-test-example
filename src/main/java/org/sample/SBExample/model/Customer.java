package org.sample.SBExample.model;

import org.sample.SBExample.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        logger.debug("Initialized a new " + this);
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName=%s, lastName=%s", id, firstName, lastName);
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(Customer c) {
        logger.debug("Matching equality of " + this + " and " + c);
        return id.equals(c.getId()) && firstName.equals(c.getFirstName()) && lastName.equals(c.getLastName());
    }
}
