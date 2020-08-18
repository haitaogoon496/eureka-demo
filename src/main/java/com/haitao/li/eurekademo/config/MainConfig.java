package com.haitao.li.eurekademo.config;

import com.haitao.li.eurekademo.classes.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MainCoinfig
 * @Description TODO
 * @Author lihaitao
 * @Date 2020/4/4 22:35
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.haitao.li.eurekademo.classes")
public class MainConfig {


    @Bean(initMethod = "initMethod",destroyMethod = "destroy")
    public Person person() {
        Person person = new Person();
        person.setName("liht");
        person.setSex(0);
        person.setHigh(179);
        return person;
    }
}
