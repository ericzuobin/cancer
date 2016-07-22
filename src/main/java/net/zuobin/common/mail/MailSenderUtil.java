package net.zuobin.common.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @author Sahinn
 * @date 16/7/22
 */
@Component("mailSendUtil")
public class MailSenderUtil {

    protected  final Logger logger = LoggerFactory.getLogger(MailSenderUtil.class);

    @Autowired
    Configuration configuration;

    @Autowired (required = false)
    private JavaMailSender mailSender;

    public String generateEmailContentByFreeMarker(String templateName,
                                                   Map<?, ?> map) {
        try {
            if (StringUtils.isEmpty(templateName)) {
                templateName = "mailDefault.ftl";
            }

            Template template = configuration.getTemplate(templateName);
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        } catch (TemplateException e) {
            logger.error("Error while processing FreeMarker template ", e);
        } catch (FileNotFoundException e) {
            logger.error("Error while open template file ", e);
        } catch (IOException e) {
            logger.error("Error while generate Email Content ", e);
        }
        return null;
    }

    /**
     * 发送邮件
     *
     * @param emailAddresses
     *            收件人Email地址的数组
     * @param fromEmail
     *            寄件人Email地址, null为默认寄件人web@vnvtrip.com * @param bodyText 邮件正文
     * @param subject
     *            邮件主题
     * @param attachmentName
     *            附件名
     * @param resource
     *            附件
     * @throws MessagingException
     */
    public void sendMessageAndResource(String[] emailAddresses, String fromEmail,
                            String bodyText, String subject, String attachmentName,
                            ClassPathResource resource) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        // a multipart message
        MimeMessageHelper helper = null;

        helper = new MimeMessageHelper(message, true);
        helper.setTo(emailAddresses);
        if (fromEmail != null) {
            helper.setFrom(fromEmail);
        }
        helper.setText(bodyText, true);
        helper.setSubject(subject);

        if (attachmentName != null && resource != null) {
            helper.addAttachment(attachmentName, resource);
        }

        mailSender.send(message);
    }

    /**
     * 使用模版发送HTML格式的邮件
     *
     * @param msg
     *            装有to,from,subject信息的SimpleMailMessage
     * @param templateName
     *            模版名,模版根路径已在配置文件定义于freemakarengine中
     * @param model
     *            渲染模版所需的数据
     */
    public void send(SimpleMailMessage msg, String templateName, Map<?, ?> model) throws Exception {
        // 生成html邮件内容
        String content = generateEmailContentByFreeMarker(templateName, model);
        MimeMessage mimeMsg = null;

        mimeMsg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "utf-8");
        helper.setTo(msg.getTo());

        if (msg.getSubject() != null)
            helper.setSubject(msg.getSubject());

        if (msg.getFrom() != null)
            helper.setFrom(msg.getFrom());

        helper.setText(content, true);

        mailSender.send(mimeMsg);
    }

    /**
     * 使用模版发送HTML格式的邮件
     *
     * @param emailAddresses
     * @param fromEmail
     * @param subject
     *            装有to,from,subject信息
     * @param templateName
     *            模版名,模版根路径已在配置文件定义于freemakarengine中
     * @param model
     *            渲染模版所需的数据
     */
    public void send(String[] emailAddresses, String fromEmail, String subject, String templateName, Map<?, ?> model) throws Exception {
        // 生成html邮件内容
        String content = generateEmailContentByFreeMarker(templateName, model);
        MimeMessage mimeMsg = null;

        mimeMsg = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;

        helper = new MimeMessageHelper(mimeMsg, true);
        helper.setTo(emailAddresses);
        if (fromEmail != null) {
            helper.setFrom(fromEmail);
        }
        helper.setText(content, true);
        helper.setSubject(subject);

        mailSender.send(mimeMsg);
    }


    /**
     * 发送邮件
     *
     * @param emailAddresses
     *            收件人Email地址的数组
     * @param fromEmail
     *            寄件人Email地址, null为默认寄件人web@vnvtrip.com * @param bodyText 邮件正文
     * @param subject
     *            邮件主题
     * @throws MessagingException
     */
    public void sendMessage(String[] emailAddresses, String fromEmail,
                            String bodyText, String subject) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        // a multipart message
        MimeMessageHelper helper = null;

        helper = new MimeMessageHelper(message, true);
        helper.setTo(emailAddresses);
        if (fromEmail != null) {
            helper.setFrom(fromEmail);
        }
        helper.setText(bodyText, true);
        helper.setSubject(subject);

        mailSender.send(message);
    }

    public void send(SimpleMailMessage msg) throws Exception{
        mailSender.send(msg);
    }


}
