package net.zuobin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sahinn
 * @date 16/7/14
 */
@RestController
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public String home(){
        return "hello cancer!!!";
    }

}
