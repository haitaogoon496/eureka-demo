package com.haitao.li.eurekademo;

import com.haitao.li.eurekademo.config.MainConfig;
import com.haitao.li.eurekademo.service.factory.HuipuComputer;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
@EnableEurekaServer
@EnableAspectJAutoProxy
public class EurekaDemoApplication {


    @Resource
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SpringApplication.run(EurekaDemoApplication.class, args);


//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//
//        annotationConfigApplicationContext.register(MainConfig.class);
//
//        ConfigurableListableBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();
//        beanFactory.registerSingleton("", "");
//
//
//        annotationConfigApplicationContext.refresh();
//
//        Class clazz = EurekaDemoApplication.class;
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
//            String name = annotation.name();
//            Class<? extends Method> aClass = method.getClass();
//            method.invoke(aClass, null);
//
//        }
//
//
//        annotationConfigApplicationContext.getBean("userDao");

    }

}
