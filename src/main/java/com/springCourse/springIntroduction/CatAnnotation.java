package com.springCourse.springIntroduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//если не прописать имя бина вручную, то его имя будет дефолтным: имя класса, с прописной (но не в случае
// где много заглавных вначале SQLtest)
@Component("catBean")
@Scope("singleton") //default
public class CatAnnotation implements Pet{

    public CatAnnotation() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }

    @PostConstruct
    private void init(){
        System.out.println("Cat. Init method called");
    }
    @PreDestroy
    private void destroy(){
        System.out.println("Cat. Destroy: destroy method");
    }
}
