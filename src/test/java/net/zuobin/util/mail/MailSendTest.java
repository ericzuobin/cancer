package net.zuobin.util.mail;

import net.zuobin.Applycation;
import net.zuobin.common.mail.MailSenderUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sahinn
 * @date 16/7/22
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Applycation.class)
@WebAppConfiguration
public class MailSendTest {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired(required = false)
    private JavaMailSender mailSender;

    @Autowired
    @Qualifier("mailSendUtil")
    private MailSenderUtil mailSenderUtil;

    @Test
    public void mailSendTest() throws Exception{

        System.out.println(freeMarkerConfigurer);


        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("sahinn@126.com");
        helper.setTo("sahinn@126.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        //mailSender.send(mimeMessage);

        System.out.println(mailSender);

    }

    @Test
    public void mailSendFreemarker() throws Exception{

        String[] mails = new String[]{"sahinn@126.com"};

        //mailSenderUtil.sendMessage(mails,"sahinn@126.com","Test","Test");


        Map map = new HashMap<String,String>();

        map.put("name", "Sahinn");
        map.put("content", "Hello World!");

        mailSenderUtil.send(mails,"sahinn@126.com","Test", null, map);
    }

}
