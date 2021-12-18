package com.example.sprintmongo.repository;

import com.example.sprintmongo.model.Animal;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepo extends MongoRepository<Animal, Long> {
    List<Animal> findByAnimalName(@Param("animalName") String animalName);

}
