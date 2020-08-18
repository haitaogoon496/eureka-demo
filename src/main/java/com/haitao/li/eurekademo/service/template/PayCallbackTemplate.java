package com.haitao.li.eurekademo.service.template;

/**
 * @ClassName PayTemplate
 * @Description TODO
 * @Author lihaitao
 * @Date 2020/4/1 14:37
 * @Version 1.0
 */
public abstract class PayCallbackTemplate {

    String callback(String param) {
        validate();
        // 共同处理


        buildResult();
        return null;
    }

    abstract void validate();

    abstract String buildResult();

}
