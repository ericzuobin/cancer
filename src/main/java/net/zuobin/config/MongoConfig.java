package net.zuobin.config;

import net.zuobin.config.mongo.LogMongoConfig;
import net.zuobin.config.mongo.TicketMongoConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Sahinn
 * @date 16/7/21
 */
@Configuration
@Import({TicketMongoConfig.class, LogMongoConfig.class})
public class MongoConfig {
}
