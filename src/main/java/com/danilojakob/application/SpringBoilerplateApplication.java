package com.danilojakob.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring Main Method
 * @copyright Danilo Jakob
 */
@SpringBootApplication
public class SpringBoilerplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoilerplateApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
