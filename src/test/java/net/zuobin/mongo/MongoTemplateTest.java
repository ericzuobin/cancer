package net.zuobin.mongo;

import net.zuobin.Applycation;
import net.zuobin.dao.mongo.ticket.TicketMongoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Sahinn
 * @date 16/7/21
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Applycation.class)
@WebAppConfiguration
public class MongoTemplateTest {

    @Autowired
    private TicketMongoDao ticketMongoDao;

    @Autowired
    @Qualifier("ticketMongoTemplate")
    private MongoTemplate ticketTemplate;

    @Autowired
    @Qualifier("logMongoTemplate")
    private MongoTemplate logTemplate;


    @Test
    public void save() throws Exception {

    }

}
