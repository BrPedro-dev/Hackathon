package org.academiadecodigo.hackaton.models.resources;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Supplies extends Resource{
    private final String name = "Supplies";
    private Integer id;

    public Supplies(){
        super.setQuantity(10);
    }
}
