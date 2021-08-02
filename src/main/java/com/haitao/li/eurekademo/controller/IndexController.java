package com.haitao.li.eurekademo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liht
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping("index")
    public String index() {
        if (true) {
            throw new RuntimeException("");
        }
        return "index";
    }
}
