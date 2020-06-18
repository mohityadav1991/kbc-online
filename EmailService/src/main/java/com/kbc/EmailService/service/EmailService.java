package com.kbc.EmailService.service;

import com.kbc.EmailService.BO.MessageDetail;
import com.kbc.EmailService.exception.GeneralException;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private static Log log = LogFactory.getLog(EmailService.class);

    public void sendEmail(MessageDetail messageDetail) throws MailException {

        SimpleMailMessage msg = new SimpleMailMessage();
        String emails[]= messageDetail.getEmails().toArray(new String[0]);

        msg.setTo(emails);

        msg.setSubject(messageDetail.getSubject());
        msg.setText(messageDetail.getText());

        log.info("sending email..." +messageDetail.toString());
        try {
            javaMailSender.send(msg);
        }
        catch (MailException e){
            log.error("error while sending mail"+messageDetail.toString() + " "+e.getMessage());
            throw new GeneralException("ER3",e.getMessage());
        }
    }
}