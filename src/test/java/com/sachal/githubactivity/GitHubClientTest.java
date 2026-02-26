package com.sachal.githubactivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GitHubClientTest {

    @Test
    void wiringReturnsSomeResponse() {
        GitHubClient client = new GitHubClient();
        ApiResponse response = client.wiring("octocat");
        assertNotNull(response);
        // simple smoke test: we just care that we got *something* back
        assertNotNull(response.getBody());
    }
}
