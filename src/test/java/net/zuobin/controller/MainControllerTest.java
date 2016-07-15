package net.zuobin.controller;

import net.zuobin.Applycation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zuobin on 16/7/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Applycation.class)
@WebAppConfiguration
public class MainControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
    }

    @Test
    public void home() throws Exception {

        ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON));
        actions.andExpect(status().isOk());
        System.out.println(actions.andReturn().getResponse().getContentAsString());
        actions.andExpect(MockMvcResultMatchers.content().string("hello cancer!!!"));
    }

}