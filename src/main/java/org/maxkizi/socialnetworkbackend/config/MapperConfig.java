package org.maxkizi.socialnetworkbackend.config;

import org.maxkizi.socialnetworkbackend.mapper.UserDtoConverter;
import org.springframework.context.annotation.Bean;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfig {

    @Bean
    public UserDtoConverter userDtoMapper() {
        return Mappers.getMapper(UserDtoConverter.class);
    }


}