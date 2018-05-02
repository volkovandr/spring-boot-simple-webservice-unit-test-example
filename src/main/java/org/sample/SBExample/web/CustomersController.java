package org.sample.SBExample.web;


import org.sample.SBExample.model.Customer;
import org.sample.SBExample.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private CustomerService customerService;

    @RequestMapping("")
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<Customer>();
        customerService.getCustomers().forEach(customers::add);
        return customers;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestBody Customer json) {
        customerService.newCustomer(json.getFirstName(), json.getLastName());
        return "OK";
    }
}
