package services;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Stateless
@LocalBean
public class Mail {

    @Resource(mappedName="java:/jboss/mail/gmail")
    Session gmailSession;

    public void sendMessage(String from, String to, String subject, String content) throws MessagingException {
        Message message = new MimeMessage(gmailSession);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(content);

        Transport.send(message);
    }
}
