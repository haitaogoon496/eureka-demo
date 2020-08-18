package com.haitao.li.eurekademo;

import com.haitao.li.eurekademo.classes.Person;
import com.haitao.li.eurekademo.config.MainConfig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName SpringApplication
 * @Description TODO
 * @Author lihaitao
 * @Date 2020/4/4 22:35
 * @Version 1.0
 */
public class SpringApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        BeanFactory factory = new ClassPathXmlApplicationContext("");
        Person person = annotationConfigApplicationContext.getBean("person", Person.class);
        System.out.println(person);
    }


    public void start() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("/", "d:\\liht");
        tomcat.start();
        tomcat.getServer().await();

    }
}
