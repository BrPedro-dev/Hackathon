package org.academiadecodigo.hackaton.models.resources;


import javax.persistence.Entity;

@Entity
public class Water extends Resource {

    private String name;
    private Integer lts = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLts() {
        return lts;
    }

    public void setLts(Integer lts) {
        this.lts = lts;
    }
}
