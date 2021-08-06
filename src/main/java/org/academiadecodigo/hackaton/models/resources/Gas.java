package org.academiadecodigo.hackaton.models.resources;

import javax.persistence.Entity;

@Entity
public class Gas extends Resource {

    private String name;
    private Integer galons = 100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGalons() {
        return galons;
    }

    public void setGalons(Integer galons) {
        this.galons = galons;
    }
}
