package com.example.BankProject.service.impl;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to,String subject,String message){
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message,true);

            mailSender.send(mimeMessage);
            System.out.println("✅ Email sent successfully to " + to);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error sending email: " + e.getMessage());
        }
    }
}
