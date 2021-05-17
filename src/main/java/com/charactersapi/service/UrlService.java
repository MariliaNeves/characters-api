package com.charactersapi.service;

import com.charactersapi.entity.Url;
import com.charactersapi.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private int id;

    @Transactional
    public List<Url> saveAll(List<Url> urlList){
        id = urlRepository.findMaxId() == null? 0 : urlRepository.findMaxId() + 1;
        urlList.forEach((Url item) -> {
            item.setId(id);
            id++;
        });
        return urlRepository.saveAll(urlList);
    }

}
