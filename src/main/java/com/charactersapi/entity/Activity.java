package com.charactersapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by  Marília
 * Date: 16/05/2021
 */

@Entity
public class Activity {

    @Id
    public Integer id;
    public Integer available;
    public String collectionURI;
    public Integer returned;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_item")
    public List<Item> items;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JsonBackReference
    public Character character;

    @JsonBackReference
    public Integer tipoActivity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Integer getTipoActivity() {
        return tipoActivity;
    }

    public void setTipoActivity(Integer tipoActivity) {
        this.tipoActivity = tipoActivity;
    }
}
