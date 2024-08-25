package com.example.starwarsapi.controller;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.persistence.entity.Planet;
import com.example.starwarsapi.service.CharacterService;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars-api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @ExceptionHandler({ java.lang.Exception.class })
    public void handleException() {
        System.out.println("Java lang exception");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Integer id) {
        Character character = characterService.getCharacterById(id);
        if (character == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(character);
    }

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        return ResponseEntity.status(200).body(characterService.getAllCharacters());
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        try {
            if (character.getAge() > 1000 || character.getAge() < 0) return ResponseEntity.status(400).body(null);
            return ResponseEntity.status(200).body(characterService.createCharacter(character));
        }
        catch (Exception e) {
            System.out.println("Error creating character: " + e.getMessage());
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character) {
        return ResponseEntity.status(200).body(characterService.updateCharacter(character));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        try {
            characterService.deleteCharacterById(id);
            return ResponseEntity.status(200).body(null);
        }
        catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/{id}/is-character-old-wookie")
    public ResponseEntity<Boolean> isCharacterAnOldWookie(@PathVariable Integer id) {
        Boolean isCharacterAnOldWookie = characterService.isCharacterOldWookie(id);
        if (isCharacterAnOldWookie == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(isCharacterAnOldWookie);
    }

    @GetMapping("/average-weight")
    public ResponseEntity<Double> getAverageWeight() {
        Double averageWeight = characterService.getAverageWeightOfAllCharacters();
        return ResponseEntity.status(200).body(averageWeight);
    }

    @GetMapping("/{id}/is-taller-than-average-specie")
    public ResponseEntity<Boolean> isCharacterTallerThanAverageHeightOfSpecie(@PathVariable Integer id) {
        Boolean isCharacterTaller = characterService.isCharacterTallerThanAverageHeightOfSpecie(id);
        if (isCharacterTaller == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(isCharacterTaller);
    }

    @GetMapping("/heaviest-by-specie")
    public ResponseEntity<List<Character>> getHeaviestCharacterByEachSpecie() {
        return ResponseEntity.status(200).body(characterService.getHeaviestCharacterByEachSpecie());
    }

    public ResponseEntity<Character> getHeaviestCharacterOnPlanet(String planetName) {
        return ResponseEntity.status(200).body(characterService.getHeaviestCharacterOnPlanet(planetName));
    }

    //Done by Radhi @Bajahaw
}
