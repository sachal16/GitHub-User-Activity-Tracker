package com.sachal.githubactivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitHubClientTest {

    @Test
    void wiringReturnsResponse() {
        GitHubClient client = new GitHubClient();
        ApiResponse response = client.wiring("octocat");
        assertNotNull(response);
        assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 404 || response.getStatusCode() == -1);
    }

    @Test
    void wiringWithInvalidUser() {
        GitHubClient client = new GitHubClient();
        ApiResponse response = client.wiring("this-user-probably-does-not-exist-12345");
        assertNotNull(response);
        assertNotNull(response.getBody());
    }
}
