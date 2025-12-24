package com.sachal.githubactivity;

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
                ApiResponse response = clientTest.wiring("sachal16");
                System.out.println(response.getStatusCode());
                System.out.println(response.getBody());
            }
        }




    }
}
