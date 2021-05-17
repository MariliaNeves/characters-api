package com.charactersapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Entity
public class Url {

    @Id
    public Integer id;
    public String type;
    public String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
