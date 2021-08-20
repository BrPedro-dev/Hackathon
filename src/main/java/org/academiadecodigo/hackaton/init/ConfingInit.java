package org.academiadecodigo.hackaton.init;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfingInit {

    @Bean
    public InitDatabse initDatabse(){
        return new InitDatabse();
    }
}
