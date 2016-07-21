package net.zuobin.config.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Sahinn
 * @date 16/7/21
 */
@Configuration
@EnableMongoRepositories(basePackages = "net.zuobin.dao.mongo.log", mongoTemplateRef = "logMongoTemplate")
public class LogMongoConfig {

    @Autowired(required = false)
    private MongoClientOptions options;

    public MongoClientOptions getLogMongoClientOptions(){
        return MongoClientOptions.builder().socketKeepAlive(true)
                .connectTimeout(10000)
                .socketTimeout(10000).maxWaitTime(1000*60*2)
                .threadsAllowedToBlockForConnectionMultiplier(50)
                .readPreference(ReadPreference.primary()).build();
    }

    @Autowired
    private Environment environment;

    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb.log")
    public MongoProperties firstMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name = "logMongoTemplate")
    public MongoTemplate firstMongoTemplate() throws Exception {
        MongoProperties mongoProperties = firstMongoProperties();
        MongoClient mongoClient = mongoProperties.createMongoClient(getLogMongoClientOptions(),environment);
        return new MongoTemplate(mongoClient, mongoProperties.getDatabase());
    }

}
