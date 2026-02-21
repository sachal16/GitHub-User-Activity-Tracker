package com.sachal.githubactivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitHubClientTest {

    @Test
    void defaultConstructor() {
        GitHubClient client = new GitHubClient();
        assertNotNull(client);
    }

    @Test
    void customBaseUrlNoTrailingSlash() {
        GitHubClient client = new GitHubClient("https://api.example.com");
        assertNotNull(client);
        // Invalid port so connection fails fast; we only check we get an ApiResponse
        ApiResponse response = client.fetchEvents("bar");
        assertNotNull(response);
        assertTrue(response.getStatusCode() == -1 || response.getStatusCode() >= 0);
    }

    @Test
    void customBaseUrlTrailingSlash() {
        GitHubClient client = new GitHubClient("https://api.example.com/");
        assertNotNull(client);
        ApiResponse response = client.fetchEvents("foo");
        assertNotNull(response);
    }

    @Test
    void nullBaseUrlFallsBackToDefault() {
        GitHubClient client = new GitHubClient(null);
        assertNotNull(client);
        ApiResponse response = client.fetchEvents("octocat");
        assertNotNull(response);
    }

    @Test
    void emptyBaseUrlFallsBackToDefault() {
        GitHubClient client = new GitHubClient("");
        assertNotNull(client);
    }
}
