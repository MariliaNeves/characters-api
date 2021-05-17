package com.charactersapi.service;

import com.charactersapi.entity.Item;
import com.charactersapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private int id;
    @Transactional
    public List<Item> saveAll(List<Item> itemList){
        id = itemRepository.findMaxId() == null? 0 : itemRepository.findMaxId() + 1;
        itemList.forEach((Item item) -> {item.setId(id); id++; });
        return itemRepository.saveAll(itemList);
    }

}
