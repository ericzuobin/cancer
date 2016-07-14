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
public class Applycation {

    public static void main(String[] args) {
        SpringApplication.run(Applycation.class,args);
    }
}
