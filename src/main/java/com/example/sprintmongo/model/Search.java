package com.example.sprintmongo.model;

public class Search {
    private String topic;
    private String database;

    public Search(){

    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "Search{" +
                "topic='" + topic + '\'' +
                ", database='" + database + '\'' +
                '}';
    }
}
