package org.sample.SBExample.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.sample.SBExample.model.Customer;
import org.sample.SBExample.repository.CustomerRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.yml")
public class CustomerServiceTest {

    @MockBean
    CustomerRepository customerRepository;

    @Test
    public void service_creates_customers() {
        CustomerService customerService = new CustomerService(customerRepository);
        customerService.newCustomer("John", "Dow");
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(captor.capture());
        assertThat("John", equalTo(captor.getValue().getFirstName()));
        assertThat("Dow", equalTo(captor.getValue().getLastName()));
    }

    @Test
    public void service_finds_customers() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("John", "Dow"));
        given(customerRepository.findAll()).willReturn(customers);
        CustomerService customerService = new CustomerService(customerRepository);
        Iterable<Customer> selected = customerService.getCustomers();
        List<Customer> selectedList = new ArrayList<Customer>();
        selected.forEach(selectedList::add);
        assertThat(selectedList.size(), greaterThan(0));
        for(Customer customer : selectedList) {
            assertThat(customers, contains(customer));
        }
        for(Customer customer : customers) {
            assertThat(selectedList, contains(customer));
        }
    }
}
