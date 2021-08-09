package org.academiadecodigo.hackaton.models.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplies extends Resource{
    private final String name = "Supplies";
    private Integer id;

    public Supplies(){
        super.setQuantity(10);
        super.setName(name);
    }
}
