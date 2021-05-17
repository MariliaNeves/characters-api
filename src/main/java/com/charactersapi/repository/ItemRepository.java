package com.charactersapi.repository;

import com.charactersapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("select max(s.id) from Item s")
    public Integer findMaxId();

}
