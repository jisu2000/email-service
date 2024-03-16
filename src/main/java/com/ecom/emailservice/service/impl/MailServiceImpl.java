package com.ecom.emailservice.service.impl;

import java.util.Arrays;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ecom.emailservice.model.MailWithoutFile;
import com.ecom.emailservice.playload.ApiResponse;
import com.ecom.emailservice.service.MailService;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public ApiResponse sendMaiilWithOutFile(MailWithoutFile msg) {

        String error = "";
        try {

            System.out.println("Sending mail to "+msg.getRecipentEmail());
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(msg.getRecipentEmail());
            helper.setSubject(msg.getSubject());
            helper.setText(msg.getBody());
            javaMailSender.send(message);

            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMsg("Mail send Successfully");
            apiResponse.setStatus(HttpStatus.OK);

            return apiResponse;
        } catch (Exception e) {
            error = e.getMessage();
        }
        return new ApiResponse(error, HttpStatus.BAD_REQUEST);
    }

}
