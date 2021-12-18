package com.example.sprintmongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "search")
public class Search {
    @Id
    private String id;

    private String topic;
    private String database;

    // Empty constructor
    public Search() {
    }

    // Default Constructor
    public Search(String topic, String database) {
        this.topic = topic;
        this.database = database;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
