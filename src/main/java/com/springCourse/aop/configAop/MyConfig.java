package com.springCourse.aop.configAop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com/springCourse/aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
