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
                System.out.println("Invalid username");
            }else{
                System.out.println(username);
            }
        }

    }
}
