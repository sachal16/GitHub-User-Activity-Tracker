package com.sachal.githubactivity;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {


        //no usernamegiven -> printed Usage
        if(args.length==0){
            System.out.println("Usage: github-activity <username>");
            return;
        }else{
            String username=args[0];
            username=username.trim();
            if(username.isEmpty()){
                System.out.println("Invalid username; Usage: github-activity <username>");
                return;
            }else{
                System.out.println(username);
                GitHubClient clientTest = new GitHubClient();
                ApiResponse response = clientTest.wiring(username);

                if(response.getStatusCode() != 200){
                    System.out.println("Request Failed: " + response.getStatusCode());
                    System.out.println(response.getBody());
                    return;
                }
                Gson gson = new Gson();
                Event[] events = gson.fromJson(response.getBody(), Event[].class);
                for (Event e : events){
                    if(!"PushEvent".equals(e.type)){
                        continue;
                    }

                    String repoName = "unknown-repo";
                    if(e.repo != null && e.repo.name != null){
                        repoName = e.repo.name;
                    }

                    int commits = 0;
                    if(e.payload != null && e.payload.size != null){
                        commits = e.payload.size;
                    }
                    System.out.println("Pushed: " + commits + " of " + repoName);
                }


            }
        }




    }
}
