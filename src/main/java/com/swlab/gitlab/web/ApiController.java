package com.swlab.gitlab.web;

import com.swlab.gitlab.config.properties.GitlabProperties;
import com.swlab.gitlab.utils.ApiResult;

import lombok.extern.slf4j.Slf4j;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.swlab.gitlab.utils.ApiUtils.success;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private GitlabProperties gitlabProperties;

    private GitLabApi gitLabApi;

    public ApiController(GitlabProperties gitlabProperties) {
        this.gitlabProperties = gitlabProperties;
    }

    public GitLabApi getGitLabApi() {
        return new GitLabApi(gitlabProperties.getUrl(), gitlabProperties.getPersonalAccessToken());
    }

    @GetMapping("/gitlab/version")
    public ApiResult<GitLabApi.ApiVersion> getGitLabApiVersion() {
        this.gitLabApi = getGitLabApi();
        return success(gitLabApi.getApiVersion());
    }

    @GetMapping("/gitlab/projects")
    public ApiResult<List<Project>> getGitLabProjects() throws GitLabApiException {
        this.gitLabApi = getGitLabApi();
        return success(gitLabApi.getProjectApi().getProjects());
    }

    @GetMapping("/gitlab/users")
    public ApiResult<List<User>> getGitLabUsers() throws GitLabApiException {
        this.gitLabApi = getGitLabApi();
        return success(gitLabApi.getUserApi().getActiveUsers());
    }
}
