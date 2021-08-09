package org.academiadecodigo.hackaton.models.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Weapons extends Resource {

    private final String name = "Weapons";
    private Integer id;

    public Weapons() {
        super.setQuantity(2);
        super.setName(name);
    }


}
