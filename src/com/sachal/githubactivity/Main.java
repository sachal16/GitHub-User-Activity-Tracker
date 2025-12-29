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
            if(username.length()==0){
                System.out.println("Invalid username; Usage: github-activity <username>");
            }else{
                System.out.println(username);
                GitHubClient clientTest = new GitHubClient();
                ApiResponse response = clientTest.wiring(username);

                if(response.getStatusCode() != 200){
                    System.out.println("Request Failed" + response.getStatusCode());
                    System.out.println(response.getBody());
                    return;
                }
                Gson gson = new Gson();
                Event[] events = gson.fromJson(response.getBody(), Event[].class);
                for (Event event : events){

                }


            }
        }




    }
}
