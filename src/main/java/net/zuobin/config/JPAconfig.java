package net.zuobin.config;

import net.zuobin.config.database.JPAPrimaryConfig;
import net.zuobin.config.database.JPASecondaryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Sahinn
 * @date 16/7/14
 */
@Configuration
@Import({JPAPrimaryConfig.class,JPASecondaryConfig.class})
public class JPAconfig {
}
