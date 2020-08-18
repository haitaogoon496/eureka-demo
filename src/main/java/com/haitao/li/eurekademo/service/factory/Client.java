package com.haitao.li.eurekademo.service.factory;

import com.haitao.li.eurekademo.service.proxy.BaseInterface;
import com.haitao.li.eurekademo.service.proxy.ConcertImpl;
import com.haitao.li.eurekademo.service.proxy.ConcertProxyImpl;

/**
 * @ClassName Client
 * @Description TODO
 * @Author lihaitao
 * @Date 2020/4/1 14:21
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {


        Factory factory = new HpComputerFactory();
        factory.createComputerFactory().getComputerName();


        factory = new LenvoComputerFactory();
        factory.createComputerFactory().getComputerName();


        BaseInterface concert = new ConcertImpl();

        BaseInterface proxy = new ConcertProxyImpl(concert);
        proxy.execute();



    }
}
