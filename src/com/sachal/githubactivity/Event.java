package com.sachal.githubactivity;

public class Event {
    public String type;
    public Repo repoistory;
    public UserUploads uploads;

    public static class Repo{
        public String name;
    }
    public static class UserUploads{
        public Integer size;
    }
}
