package org.academiadecodigo.hackaton.models.resources;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Water extends Resource {

    private final String name = "Water";
    private Integer id;

    public Water(){
        super.setQuantity(20);
        super.setName(name);
    }
}
