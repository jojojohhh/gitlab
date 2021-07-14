package com.swlab.gitlab.web;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String BASEURL = "/api/v1";

    @Test
    public void getGitLabVersionTest() throws Exception {
        String url = BASEURL + "/gitlab/version";
        expectResponseIsOk(url);
    }

    @Test
    public void getGitLabProjectsTest() throws Exception {
        String url = BASEURL + "/gitlab/projects";
        expectResponseIsOk(url);
    }

    @Test
    public void getGitLabUsersTest() throws Exception {
        String url = BASEURL + "/gitlab/users";
        expectResponseIsOk(url);
    }

    public void expectResponseIsOk(String url) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(result -> {
                    MockHttpServletResponse res = result.getResponse();
                    log.info("Status: " + res.getStatus());
                    log.info("response: " + res.getContentAsString());
                });
    }


}
