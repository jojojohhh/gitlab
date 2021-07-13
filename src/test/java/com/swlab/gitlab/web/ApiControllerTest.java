package com.swlab.gitlab.web;

import com.swlab.gitlab.config.properties.GitlabProperties;

import org.gitlab4j.api.GitLabApi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private GitlabProperties gitlabProperties;

    @Autowired
    private MockMvc mockMvc;

    static final Logger log = LoggerFactory.getLogger(ApiControllerTest.class);

    private GitLabApi gitLabApi;

    public GitLabApi getGitLabApi() {
        return new GitLabApi(gitlabProperties.getUrl(), gitlabProperties.getPersonalAccessToken());
    }

    @Test
    public void getGitlabVersionTest() throws Exception {
        String url = "/api/v1/gitlab/version";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                    MockHttpServletResponse res = result.getResponse();
                    log.info(res.getContentAsString());
                });
    }


}
