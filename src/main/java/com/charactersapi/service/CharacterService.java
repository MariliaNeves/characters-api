package com.charactersapi.service;

import com.charactersapi.entity.Character;
import com.charactersapi.enuns.EnumTypeActivity;
import com.charactersapi.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ThumbnailService thumbnailService;

    @Autowired
    private UrlService urlService;

    @Transactional
    public void insert(Character character){
        saveItensByActivities(character);
        urlService.saveAll(character.getUrls());
        thumbnailService.insert(character.getThumbnail());
        character.setId(null == characterRepository.findMaxId()? 0 : characterRepository.findMaxId() + 1);
        characterRepository.save(character);
        updateAllActivities(character);

    }

    public List<Character> findAll(){
        return characterRepository.findAll();
    }

    public Optional<Character> findById(Integer id){
        return characterRepository.findById(id);
    }

    private void saveItensByActivities(Character character) {
        activityService.saveByTypeActivity(character.getComics(), EnumTypeActivity.COMICS);
        activityService.saveByTypeActivity(character.getSeries(), EnumTypeActivity.SERIES);
        activityService.saveByTypeActivity(character.getEvents(), EnumTypeActivity.EVENTS);
        activityService.saveByTypeActivity(character.getStories(), EnumTypeActivity.STORIES);
    }

    private void updateAllActivities(Character character) {
        character.getComics().setCharacter(character);
        activityService.update(character.getComics());
        character.getSeries().setCharacter(character);
        activityService.update(character.getSeries());
        character.getEvents().setCharacter(character);
        activityService.update(character.getEvents());
        character.getStories().setCharacter(character);
        activityService.update(character.getStories());
    }

}
