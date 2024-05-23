package com.example.practise_21.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
@Service
public class EmailService {
    @Async
    public void sendEmail(String method) {
        final String username = "stasy.sl@yandex.ru";
        final String password = "***********";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stasy.sl@yandex.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("stasy.sl@yandex.ru"));
            message.setSubject("Действие с базой данных");
            message.setText(method);

            Transport.send(message);

            System.out.println("Письмо отправлено!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}