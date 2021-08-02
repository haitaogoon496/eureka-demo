package com.haitao.li.eurekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
@EnableEurekaServer
@EnableAspectJAutoProxy
public class EurekaDemoApplication {


//    @Resource
//    JdbcTemplate jdbcTemplate;

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
