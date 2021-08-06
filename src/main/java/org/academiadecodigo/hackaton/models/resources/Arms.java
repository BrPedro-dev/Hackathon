package org.academiadecodigo.hackaton.models.resources;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Arms extends Resource {

    private final String name = "Arms";
    private Integer id;

    public Arms() {
        super.setQuantity(2);
    }


}
