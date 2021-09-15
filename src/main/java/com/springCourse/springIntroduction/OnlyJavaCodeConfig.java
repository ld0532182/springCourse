package com.springCourse.springIntroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("myApp.properties")
public class OnlyJavaCodeConfig {

    @Bean
    @Scope("singleton")
    public CatAnnotation catBean(){
        return new CatAnnotation();
    }
    @Bean
    public Person personBean(){
        return new Person(catBean());
    }
}
