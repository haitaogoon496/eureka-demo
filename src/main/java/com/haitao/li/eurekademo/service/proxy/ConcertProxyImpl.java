package com.haitao.li.eurekademo.service.proxy;

/**
 * @ClassName ConcertProxyImpl
 * @Description TODO
 * @Author lihaitao
 * @Date 2020/4/1 14:25
 * @Version 1.0
 */
public class ConcertProxyImpl implements BaseInterface {

    BaseInterface baseInterface;

    public ConcertProxyImpl(BaseInterface baseInterface) {

        this.baseInterface = baseInterface;
    }


    @Override
    public void execute() {

        System.out.println("before--");
        baseInterface.execute();
        System.out.println("end--");


    }
}
