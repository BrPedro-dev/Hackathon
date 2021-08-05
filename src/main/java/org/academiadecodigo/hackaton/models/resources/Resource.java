package org.academiadecodigo.hackaton.models.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.academiadecodigo.hackaton.models.AbstractModel;
import org.academiadecodigo.hackaton.models.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Resource extends AbstractModel {


    @ManyToOne
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
