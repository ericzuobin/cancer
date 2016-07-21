package net.zuobin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Sahinn
 * @date 16/7/14
 */
@Configuration
@Import({JPAconfig.class,MongoConfig.class})
public class Baseconfig {
}
