package com.example.sprintmongo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SearchTest {
    @Test
    void testConstructor() {
        Search actualSearch = new Search();
        actualSearch.setDatabase("Database");
        actualSearch.setId("42");
        actualSearch.setTopic("Topic");
        assertEquals("Database", actualSearch.getDatabase());
        assertEquals("42", actualSearch.getId());
        assertEquals("Topic", actualSearch.getTopic());
    }

    @Test
    void testConstructor2() {
        Search actualSearch = new Search("Topic", "Database");
        actualSearch.setDatabase("Database");
        actualSearch.setId("42");
        actualSearch.setTopic("Topic");
        assertEquals("Database", actualSearch.getDatabase());
        assertEquals("42", actualSearch.getId());
        assertEquals("Topic", actualSearch.getTopic());
    }
}

