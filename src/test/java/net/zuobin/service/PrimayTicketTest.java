package net.zuobin.service;

/**
 * @author Sahinn
 * @date 16/7/15
 */

import net.zuobin.Applycation;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Applycation.class)
@WebAppConfiguration
public class PrimayTicketTest {
}
