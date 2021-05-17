package com.charactersapi.characters.api.service;

import com.charactersapi.entity.Activity;
import com.charactersapi.entity.Character;
import com.charactersapi.enuns.EnumTypeActivity;
import com.charactersapi.repository.ActivityRepository;
import com.charactersapi.repository.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Marília
 * Date: 17/05/2021
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CharacterServiceTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @Test
    public void findByIdTest(){
        Optional<Character> character = characterRepository.findById(0);
        Assertions.assertEquals(character.get().name, "3-D Man");
    }

    @Test
    public void findByAllTest(){
        List<Character> characterList = characterRepository.findAll();
        Assertions.assertNotEquals(characterList, null);
    }

    @Test
    public void findByIdCharactertypeActivityTest(){
        if(characterRepository.findAll().size()>0) {
            List<Activity> activityList = activityRepository.findByIdCharacter(0, EnumTypeActivity.COMICS.getValue());
            Assertions.assertNotEquals(activityList, null);
        }
    }


}
