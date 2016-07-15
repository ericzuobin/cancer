package net.zuobin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sahinn
 * @date 16/7/14
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
//@SpringbootApplication 等同于@Configuration,@EnableAutoConfiguration和 @ComponentScan 并具有他们的默认属性值。
public class Applycation {

    public static void main(String[] args) {
        SpringApplication.run(Applycation.class,args);
    }
}
