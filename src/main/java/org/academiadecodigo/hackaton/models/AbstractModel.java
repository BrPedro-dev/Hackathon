package org.academiadecodigo.hackaton.models;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

}
