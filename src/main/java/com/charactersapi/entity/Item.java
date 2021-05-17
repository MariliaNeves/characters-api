package com.charactersapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

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

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_activity", referencedColumnName = "id", nullable = true)
    @JsonBackReference
    public Activity activity;

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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
