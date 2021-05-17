package com.charactersapi.repository;

import com.charactersapi.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {
    @Query("select max(s.id) from Url s")
    public Integer findMaxId();

}
