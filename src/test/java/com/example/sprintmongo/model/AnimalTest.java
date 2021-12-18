package com.example.sprintmongo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnimalTest {
    @Test
    void testConstructor() {
        Animal actualAnimal = new Animal();
        actualAnimal.setAnimalColor("Animal Color");
        actualAnimal.setAnimalName("Animal Name");
        actualAnimal.setAnimalOrigin("Animal Origin");
        actualAnimal.setAnimal_id(1L);
        actualAnimal.setSpecies("Species");
        assertEquals("Animal Color", actualAnimal.getAnimalColor());
        assertEquals("Animal Name", actualAnimal.getAnimalName());
        assertEquals("Animal Origin", actualAnimal.getAnimalOrigin());
        assertEquals(1L, actualAnimal.getAnimal_id());
        assertEquals("Species", actualAnimal.getSpecies());
    }

    @Test
    void testConstructor2() {
        Animal actualAnimal = new Animal(1L, "Species", "Animal Name", "Animal Color", "Animal Origin");

        assertEquals("Animal Color", actualAnimal.getAnimalColor());
        assertEquals("Species", actualAnimal.getSpecies());
        assertEquals(1L, actualAnimal.getAnimal_id());
        assertEquals("Animal Origin", actualAnimal.getAnimalOrigin());
        assertEquals("Animal Name", actualAnimal.getAnimalName());
    }
}

