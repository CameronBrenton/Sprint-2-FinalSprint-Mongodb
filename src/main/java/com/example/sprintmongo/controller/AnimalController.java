package com.example.sprintmongo.controller;

import com.example.sprintmongo.model.Animal;
import com.example.sprintmongo.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AnimalController {
    @Autowired
    AnimalRepo animalRepository;

    // Get all Animals
    @GetMapping("/animal")
    public ResponseEntity<List<Animal>> getAllAnimals(@RequestParam(required = false) String animalName) {
        try {
            List<Animal> animal = new ArrayList<Animal>();


            if (animalName == null)
                animalRepository.findAll().forEach(animal::add);
            else
                animalRepository.findByAnimalName(animalName).forEach(animal::add);

            if (animal.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(animal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/animal/{animal_id}", produces = "application/json")
    public ResponseEntity<Animal> getAnimalsByAnimal_Id(@PathVariable("animal_id") long animal_id) {
        Optional<Animal> animalData = animalRepository.findById(animal_id);
        return animalData.map(animal -> new ResponseEntity<>(animal, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/animal")
    public ResponseEntity<Animal> createAnimals(@RequestBody Animal animal) {
        try {
            Animal _animal = animalRepository
                    .save(new Animal(animal.getAnimal_id(),
                            animal.getSpecies(), animal.getAnimalName(),
                            animal.getAnimalColor(), animal.getAnimalOrigin()));
            return new ResponseEntity<>(_animal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/animal/{animal_id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable("animal_id") long animal_id, @RequestBody Animal animal) {
        Optional<Animal> animalData = animalRepository.findById(animal_id);

        if (animalData.isPresent()) {
            Animal _animal = animalData.get();
            _animal.setAnimal_id(animal.getAnimal_id());
            _animal.setSpecies(animal.getSpecies());
            _animal.setAnimalName(animal.getAnimalName());
            _animal.setAnimalColor(animal.getAnimalColor());
            _animal.setAnimalOrigin(animal.getAnimalOrigin());
            return new ResponseEntity<>(animalRepository.save(_animal), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/animal/{animal_id}")
    public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable("animal_id") long animal_id) {
        try {
            animalRepository.deleteById(animal_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
