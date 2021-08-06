package org.academiadecodigo.hackaton.dtos;

import lombok.Data;
import org.academiadecodigo.hackaton.models.resources.Resource;

import java.util.List;

@Data
public class Dto {

    private String name;
    private Integer id;
    private List<Resource> resources;

}
