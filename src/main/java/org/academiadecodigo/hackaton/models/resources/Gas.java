package org.academiadecodigo.hackaton.models.resources;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Gas extends Resource {

    private final String name = "Gas";
    private Integer id;

    public Gas(){
        super.setQuantity(100);
    }

}
