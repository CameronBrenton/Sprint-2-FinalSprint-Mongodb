package com.example.sprintmongo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("User{id=0, email='jane.doe@example.org', password='iloveyou'}", actualUser.toString());
    }

    @Test
    void testConstructor2() {
        User actualUser = new User("jane.doe@example.org", "iloveyou");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("User{id=0, email='jane.doe@example.org', password='iloveyou'}", actualUser.toString());
    }

    @Test
    void testConstructor3() {
        User actualUser = new User("jane.doe@example.org", "iloveyou", "Jane", "Doe");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("User{id=0, email='jane.doe@example.org', password='iloveyou'}", actualUser.toString());
    }

    @Test
    void testGetId() {
        assertEquals(0L, (new User()).getId().longValue());
    }

    @Test
    void testSetId() {
        User user = new User();
        user.setId(123L);
        assertEquals(123L, user.getId().longValue());
    }
}

