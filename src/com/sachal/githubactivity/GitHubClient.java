package com.sachal.githubactivity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubClient {

    private final String baseUrl;

    public GitHubClient(String baseUrl) {
        if (baseUrl == null || baseUrl.isEmpty()) {
            this.baseUrl = "https://api.github.com/";
        } else {
            this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        }
    }

    public GitHubClient() {
        this("https://api.github.com");
    }

    public ApiResponse fetchEvents(String username) {
        String url = baseUrl + "users/" + username + "/events";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/vnd.github+json")
                .header("User-Agent", "github-useractivity")
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new ApiResponse(response.statusCode(), response.body());
        } catch (Exception e) {
            return new ApiResponse(-1, e.getMessage());
        }
    }
}
