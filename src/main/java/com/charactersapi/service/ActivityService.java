package com.charactersapi.service;

import com.charactersapi.entity.Activity;
import com.charactersapi.entity.Item;
import com.charactersapi.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Transactional
    public void insert(Activity activity){
        activity.setId(null == activityRepository.findMaxId()? 0 : activityRepository.findMaxId() + 1);
        activityRepository.save(activity);
        List<Item> itens = activity.getItems();
        itens.forEach((Item item) -> {
            item.setActivity(activity);
        });
    }

    public Activity update(Activity activity){
        return activityRepository.save(activity);
    }

    public List<Activity> findByIdCharacter(Integer idCharacter, Integer tipoActivity){
        return activityRepository.findByIdCharacter(idCharacter, tipoActivity);
    }

}
