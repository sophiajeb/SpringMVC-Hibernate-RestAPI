/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.service;

import com.mycompany.theatricalplays.model.EmailMessage;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

/**
 *
 * @author mac
 */
public class EmailService {
    private EmailMessage emailMsg;
    private String password;

    public EmailService(EmailMessage emailMsg, String password) {
        this.emailMsg = emailMsg;
        this.password = password;
    }

    public EmailMessage getEmailMsg() {
        return emailMsg;
    }

    public void setEmailMsg(EmailMessage emailMsg) {
        this.emailMsg = emailMsg;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean sendEmail() {
        final String username = emailMsg.getFrom();
        final String password = this.password;

        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailMsg.getFrom()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailMsg.getTo())
            );
            message.setSubject(emailMsg.getTitle());
            message.setText(emailMsg.getBody());
                       
            Transport.send(message);

            System.out.println("Email Sent");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
