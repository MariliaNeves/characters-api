package com.charactersapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Entity
public class Item {

    @Id
    public Integer id;
    public String resourceURI;
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
