package com.charactersapi.repository;

import com.charactersapi.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query("select max(s.id) from Character s")
    public Integer findMaxId();
}
