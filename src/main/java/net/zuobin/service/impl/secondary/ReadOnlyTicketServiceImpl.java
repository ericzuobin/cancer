package net.zuobin.service.impl.secondary;

import net.zuobin.dao.secondary.ReadOnlyTicketDao;
import net.zuobin.entity.secondary.ReadOnlyTicket;
import net.zuobin.service.secondary.ReadOnlyTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sahinn
 * @date 16/7/15
 */
@Service
@Transactional("transactionManagerSecondary")
public class ReadOnlyTicketServiceImpl implements ReadOnlyTicketService {

    @Autowired
    private ReadOnlyTicketDao readOnlyTicketDao;

    @Override
    public ReadOnlyTicket save(ReadOnlyTicket readOnlyTicket) {
        return readOnlyTicketDao.save(readOnlyTicket);
    }

    @Override
    public void delete(ReadOnlyTicket readOnlyTicket) {
        readOnlyTicketDao.delete(readOnlyTicket);
    }

    @Override
    public ReadOnlyTicket update(ReadOnlyTicket readOnlyTicket) {
        return readOnlyTicketDao.save(readOnlyTicket);
    }

    @Override
    public ReadOnlyTicket findById(String id) {
        return readOnlyTicketDao.findOne(id);
    }
}
