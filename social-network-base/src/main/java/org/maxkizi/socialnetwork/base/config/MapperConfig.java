package org.maxkizi.socialnetwork.base.config;

import org.mapstruct.factory.Mappers;
import org.maxkizi.socialnetwork.base.mapper.UserDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfig {

    @Bean
    public UserDtoConverter userDtoMapper() {
        return Mappers.getMapper(UserDtoConverter.class);
    }


}