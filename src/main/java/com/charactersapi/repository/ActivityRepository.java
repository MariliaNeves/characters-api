package com.charactersapi.repository;

import com.charactersapi.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query("select max(s.id) from Activity s")
    public Integer findMaxId();

    @Query("select s from Activity s where s.character.id = :characterId and s.tipoActivity = :tipoActivity ")
    public List<Activity> findByIdCharacter(Integer characterId, Integer tipoActivity);

}
