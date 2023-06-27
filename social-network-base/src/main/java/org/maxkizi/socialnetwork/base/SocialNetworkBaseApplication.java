package org.maxkizi.socialnetwork.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.maxkizi.socialnetwork.common.repository"})
@EntityScan(basePackages = {"org.maxkizi.socialnetwork.common.entity"})
public class SocialNetworkBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkBaseApplication.class, args);
    }
}
