package org.academiadecodigo.hackaton.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.academiadecodigo.hackaton.models.resources.Gas;
import org.academiadecodigo.hackaton.models.resources.Resource;
import org.academiadecodigo.hackaton.models.resources.Water;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public User(){
        Gas gas = new Gas();
        addResource(gas);
        Water water = new Water();
        addResource(water);
    }

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user",

            // fetch accounts from database together with user
            fetch = FetchType.LAZY
    )
    private List<Resource> resources = new ArrayList<>();

    public void addResource(Resource resource) {
        resources.add(resource);
        resource.setUser(this);
    }
}
