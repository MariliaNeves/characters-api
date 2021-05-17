package com.charactersapi.controller;

import com.charactersapi.entity.Activity;
import com.charactersapi.entity.Character;
import com.charactersapi.enuns.EnumTipoActivity;
import com.charactersapi.service.ActivityService;
import com.charactersapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@RestController
@RequestMapping("characters")
public class CharactersController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private ActivityService activityService;

    @GetMapping
    private ResponseEntity info(){
        return ResponseEntity.status(HttpStatus.OK).body(characterService.findAll());
    }


    @GetMapping(value = "/{characterId}")
    private ResponseEntity findById(@PathVariable Integer characterId){
        Optional<Character> character = characterService.findById(characterId);
        if(!character.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(character);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Character not found.");
        }

    }

    @GetMapping(value = "/{characterId}/comics")
    private ResponseEntity findByIdComics(@PathVariable Integer characterId){
        List<Activity> activityList = activityService.findByIdCharacter(characterId, EnumTipoActivity.COMICS.getValue());
        if(!activityList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(activityList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comics Not found.");
        }
    }

    @GetMapping(value = "/{characterId}/events")
    private ResponseEntity findByIdEvents(@PathVariable Integer characterId){
        List<Activity> activityList = activityService.findByIdCharacter(characterId, EnumTipoActivity.EVENTS.getValue());
        if(!activityList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(activityList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Events Not found.");
        }
    }

    @GetMapping(value = "/{characterId}/series")
    private ResponseEntity findByIdSeries(@PathVariable Integer characterId){
        List<Activity> activityList = activityService.findByIdCharacter(characterId, EnumTipoActivity.SERIES.getValue());
        if(!activityList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(activityList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Series Not found.");
        }
    }

    @GetMapping(value = "/{characterId}/stories")
    private ResponseEntity findByIdStories(@PathVariable Integer characterId){
        List<Activity> activityList = activityService.findByIdCharacter(characterId, EnumTipoActivity.STORIES.getValue());
        if(!activityList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(activityList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stories Not found.");
        }
    }

   }
