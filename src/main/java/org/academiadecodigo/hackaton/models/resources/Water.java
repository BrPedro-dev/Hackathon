package org.academiadecodigo.hackaton.models.resources;


import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Water extends Resource {

    private final String name = "Water";
    private Integer id;

    public Water(){
        super.setQuantity(20);
    }
}
