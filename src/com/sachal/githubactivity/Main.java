package com.sachal.githubactivity;

import com.google.gson.Gson;

public class Main {
    private static final String GITHUB_API_BASE = "https://api.github.com";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: github-activity <username>");
            return;
        }
        String username = args[0].trim();
        if (username.isEmpty()) {
            System.err.println("Invalid username. Usage: github-activity <username>");
            return;
        }

        GitHubClient client = new GitHubClient(GITHUB_API_BASE);
        ApiResponse response = client.fetchEvents(username);

        if (response.getStatusCode() != 200) {
            System.err.println("Request failed: " + response.getStatusCode());
            if (response.getBody() != null && !response.getBody().isEmpty()) {
                System.err.println(response.getBody());
            }
            return;
        }

        Gson gson = new Gson();
        Event[] events = gson.fromJson(response.getBody(), Event[].class);
        int pushCount = 0;
        for (Event e : events) {
            if (!"PushEvent".equals(e.type)) continue;

            String repoName = e.repo != null && e.repo.name != null ? e.repo.name : "unknown-repo";
            int commits = (e.payload != null && e.payload.size != null) ? e.payload.size : 0;
            System.out.println("  " + commits + " commit" + (commits != 1 ? "s" : "") + " → " + repoName);
            pushCount++;
        }

        if (pushCount == 0) {
            System.out.println("No recent push events for " + username);
        } else {
            System.out.println("— " + pushCount + " push event" + (pushCount != 1 ? "s" : "") + " for " + username);
        }
    }
}
