package com.haitao.li.eurekademo.classes;

import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName Person
 * @Description TODO
 * @Author lihaitao
 * @Date 2020/4/4 22:36
 * @Version 1.0
 */
public class Person implements InitializingBean {

    private String name;

    private int sex;
    private int high;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private void initMethod() {
        System.out.println("initMethod");
    }

    private void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
