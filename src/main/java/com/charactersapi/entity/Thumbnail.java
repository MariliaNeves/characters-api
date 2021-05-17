package com.charactersapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Entity
public class Thumbnail {

    @Id
    public Integer id;
    public String path;
    public String extension;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

}
