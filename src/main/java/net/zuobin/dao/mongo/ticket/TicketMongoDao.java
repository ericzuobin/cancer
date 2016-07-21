package net.zuobin.dao.mongo.ticket;

import net.zuobin.entity.mongo.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Sahinn
 * @date 16/7/21
 */
//@EnableMongoRepositories(mongoTemplateRef = "ticketMongoTemplate")
public interface TicketMongoDao extends MongoRepository<Ticket,String> {

}
