package com.charactersapi.service;

import com.charactersapi.entity.Character;
import com.charactersapi.enuns.EnumTipoActivity;
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
    private ItemService itemService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ThumbnailService thumbnailService;

    @Autowired
    private UrlService urlService;

    @Transactional
    public void insert(Character character){
        //comics
        itemService.saveAll(character.getComics().getItems());
        character.getComics().setTipoActivity(EnumTipoActivity.COMICS.getValue());
        activityService.insert(character.getComics());
        itemService.updateAll(character.getComics().getItems());

        //series
        itemService.saveAll(character.getSeries().getItems());
        character.getSeries().setTipoActivity(EnumTipoActivity.SERIES.getValue());
        activityService.insert(character.getSeries());
        itemService.updateAll(character.getSeries().getItems());

        //events
        itemService.saveAll(character.getEvents().getItems());
        character.getEvents().setTipoActivity(EnumTipoActivity.EVENTS.getValue());
        activityService.insert(character.getEvents());
        itemService.updateAll(character.getEvents().getItems());

        //stories
        itemService.saveAll(character.getStories().getItems());
        character.getStories().setTipoActivity(EnumTipoActivity.STORIES.getValue());
        activityService.insert(character.getStories());
        itemService.updateAll(character.getStories().getItems());

        urlService.saveAll(character.getUrls());
        thumbnailService.insert(character.getThumbnail());
        character.setId(null == characterRepository.findMaxId()? 0 : characterRepository.findMaxId() + 1);
        characterRepository.save(character);

        //comics
        character.getComics().setCharacter(character);
        activityService.update(character.getComics());

        //series
        character.getSeries().setCharacter(character);
        activityService.update(character.getSeries());

        //events
        character.getEvents().setCharacter(character);
        activityService.update(character.getEvents());

        //stories
        character.getStories().setCharacter(character);
        activityService.update(character.getStories());
    }

    public List<Character> findAll(){
       return characterRepository.findAll();
    }

    public Optional<Character> findById(Integer id){
        return characterRepository.findById(id);
    }
}
