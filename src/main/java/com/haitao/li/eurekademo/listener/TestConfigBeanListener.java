package com.haitao.li.eurekademo.listener;

import com.haitao.li.eurekademo.config.MainConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;

import javax.sound.midi.Soundbank;

/**
 * @ClassName TestConfigBeanListener
 * @Description TODO
 * @Author lihaitao
 * @Date 2020/7/27 15:35
 * @Version 1.0
 */
@Repository
public class TestConfigBeanListener implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {


    private transient ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        MainConfig bean = applicationContext.getBean(MainConfig.class);
        System.out.println(bean+"-----------------");
        System.out.println(event);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
