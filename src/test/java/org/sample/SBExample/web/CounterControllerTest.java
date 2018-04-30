package org.sample.SBExample.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.SBExample.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CounterController.class)
@TestPropertySource("classpath:application.yml")
public class CounterControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CounterService counterService;

    @Test
    public void counterCountroller_returns_what_getCount_provides() throws Exception {
        int expectedCount = 5;
        String exoectedOutcome = "5";
        given(counterService.getCount()).willReturn(expectedCount);
        mockMvc.perform(get("/counter"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string(exoectedOutcome));
    }
}
