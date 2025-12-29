package com.sachal.githubactivity;

public class Event {
    public String type;
    public Repo repo;
    public Payload payload;

    public static class Repo{
        public String name;
    }
    public static class Payload{
        public Integer size; // possiblity of null
    }
}
