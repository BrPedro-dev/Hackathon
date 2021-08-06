package org.academiadecodigo.hackaton.models.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.academiadecodigo.hackaton.models.AbstractModel;
import org.academiadecodigo.hackaton.models.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    private User user;

    private Integer quantity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
