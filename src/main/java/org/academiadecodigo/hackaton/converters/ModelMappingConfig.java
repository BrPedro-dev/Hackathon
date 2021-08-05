package org.academiadecodigo.hackaton.converters;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {

    /**
     *     // (2nd step - converters.Package)
     *     this @Bean annotation and method modelMapper() will substitute the DTOconverters.
     *     before we @Autowire our UserRepository object in controllers package (class UserController).
     *
     *     NOTE: The 1st step was add dependency win our pom.xml, to use ModelMapper in our SpringBoot hackatoon project**
     */
    // this method Spring will instance the new ModelMapper
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
