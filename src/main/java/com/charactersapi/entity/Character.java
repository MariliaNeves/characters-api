package com.charactersapi.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Entity
public class Character {

    @Id
    public Integer id;
    public String name;
    public String description;
    public String modified;

    @OneToOne(cascade=CascadeType.PERSIST)
    public Thumbnail thumbnail;

    public String resourceURI;

    @OneToOne(cascade=CascadeType.PERSIST)
    public Activity comics;

    @OneToOne(cascade=CascadeType.PERSIST)
    public Activity series;

    @OneToOne(cascade=CascadeType.PERSIST)
    public Activity stories;

    @OneToOne(cascade=CascadeType.PERSIST)
    public Activity events;

    @OneToMany(cascade=CascadeType.PERSIST)
    public List<Url> urls;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Activity getComics() {
        return comics;
    }

    public void setComics(Activity comics) {
        this.comics = comics;
    }

    public Activity getSeries() {
        return series;
    }

    public void setSeries(Activity series) {
        this.series = series;
    }

    public Activity getStories() {
        return stories;
    }

    public void setStories(Activity stories) {
        this.stories = stories;
    }

    public Activity getEvents() {
        return events;
    }

    public void setEvents(Activity events) {
        this.events = events;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }



}
