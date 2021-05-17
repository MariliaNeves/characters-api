package com.charactersapi.service;

import com.charactersapi.entity.Activity;
import com.charactersapi.enuns.EnumTypeActivity;
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

    @Autowired
    private ItemService itemService;

    @Transactional
    public void insert(Activity activity){
        activity.setId(null == activityRepository.findMaxId()? 0 : activityRepository.findMaxId() + 1);
        activityRepository.save(activity);
    }

    public Activity update(Activity activity){
        return activityRepository.save(activity);
    }

    public List<Activity> findByIdCharactertypeActivity(Integer idCharacter, Integer typeActivity){
        return activityRepository.findByIdCharacter(idCharacter, typeActivity);
    }

    public void saveByTypeActivity(Activity activity, EnumTypeActivity type){
        itemService.saveAll(activity.getItems());
        activity.setTypeActivity(type.getValue());
        insert(activity);
    }

}
