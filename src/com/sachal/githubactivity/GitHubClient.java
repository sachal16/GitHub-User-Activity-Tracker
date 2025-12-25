package com.sachal.githubactivity;

public class GitHubClient {

    public ApiResponse wiring(String username){
        ApiResponse api = new ApiResponse(0,"placeholder");
        String url = "https://api.github.com/users/" + username +"/events";
        System.out.println(url);
        return api;
    }

}
