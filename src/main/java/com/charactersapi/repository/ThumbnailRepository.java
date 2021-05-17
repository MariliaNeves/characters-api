package com.charactersapi.repository;

import com.charactersapi.entity.Thumbnail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Repository
public interface ThumbnailRepository extends JpaRepository<Thumbnail, Integer> {
    @Query("select max(s.id) from Thumbnail s")
    public Integer findMaxId();

}
