package com.charactersapi.service;

import com.charactersapi.entity.Thumbnail;
import com.charactersapi.repository.ThumbnailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Service
public class ThumbnailService {

    @Autowired
    private ThumbnailRepository thumbnailRepository;

    @Transactional
    public void insert(Thumbnail thumbnail){
        thumbnail.setId(null == thumbnailRepository.findMaxId()? 0 : thumbnailRepository.findMaxId() + 1);
        thumbnailRepository.save(thumbnail);
    }

}
