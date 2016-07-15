package net.zuobin.service.impl.primary;

import net.zuobin.dao.primary.TicketDao;
import net.zuobin.entity.primary.Ticket;
import net.zuobin.service.primary.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sahinn
 * @date 16/7/15
 */
@Service
@Transactional("transactionManagerPrimary")
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketDao ticketDao;

    @Override
    public Ticket save(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    public Ticket findById(String id) {
        return ticketDao.findOne(id);
    }
}
