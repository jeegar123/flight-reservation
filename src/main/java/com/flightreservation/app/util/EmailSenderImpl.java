package com.flightreservation.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;

    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String filePath) {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Flight Details");
            mimeMessageHelper.setText("Please check your attachments");
            mimeMessageHelper.addAttachment("Details",new File(filePath));
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
