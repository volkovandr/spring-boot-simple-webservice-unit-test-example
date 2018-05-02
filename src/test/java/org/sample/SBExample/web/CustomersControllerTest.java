package org.sample.SBExample.web;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.sample.SBExample.model.Customer;
import org.sample.SBExample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomersController.class)
@TestPropertySource("classpath:application.yml")
public class CustomersControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Test
    public void controller_can_create_new_customers() throws Exception {
        String testFirstName = "John", testLastName = "Dow";
        String jsonString = "{\"firstName\": \"" + testFirstName + "\", \"lastName\": \"" + testLastName + "\"}";
        mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
        ArgumentCaptor<String> passedFirstName = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> passedLastName = ArgumentCaptor.forClass(String.class);
        verify(customerService).newCustomer(passedFirstName.capture(), passedLastName.capture());
        assertThat(testFirstName, equalTo(passedFirstName.getValue()));
        assertThat(testLastName, equalTo(passedLastName.getValue()));
    }

    @Test
    public void controller_can_list_all_customers() throws Exception {
        Customer testCustomer1 = new Customer("one", "two");
        testCustomer1.setId(1L);
        Customer testCustomer2 = new Customer("three", "four");
        testCustomer2.setId(2L);
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(testCustomer1);
        customerList.add(testCustomer2);

        given(customerService.getCustomers()).willReturn(customerList);
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[{'id': 1, 'firstName': 'one', 'lastName': 'two'}, {'id': 2, 'firstName': 'three', 'lastName': 'four'}]"));
    }
}
