package net.zuobin.service.impl.primary;

import net.zuobin.Applycation;
import net.zuobin.entity.primary.Ticket;
import net.zuobin.service.primary.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by zuobin on 16/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Applycation.class)
@WebAppConfiguration
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void findById() throws Exception {
        Ticket ticket = ticketService.findById("1151003000000034841");
        System.out.println(ticket);
    }

}