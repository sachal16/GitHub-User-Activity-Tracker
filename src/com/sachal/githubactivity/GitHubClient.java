package com.sachal.githubactivity;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

public class GitHubClient {

    public ApiResponse wiring(String username){
        String url = "https://api.github.com/users/" + username +"/events";
        System.out.println(url);

        //first string = h-name
        //second string = h-value
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .header("Accept", "application/vnd.github+json")
                .header("User-Agent", "github-useractivity")
                .build();
        try{
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            String body = response.body();
            return new ApiResponse(statusCode,body);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ;
    }

}
