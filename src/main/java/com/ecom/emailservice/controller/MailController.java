package com.ecom.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.emailservice.model.MailWithoutFile;
import com.ecom.emailservice.playload.ApiResponse;
import com.ecom.emailservice.service.MailService;

import jakarta.mail.Message;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send-mail")
    private ApiResponse sendMail(@RequestBody MailWithoutFile message) {
        ApiResponse apiResponse = this.mailService.sendMaiilWithOutFile(message);

        return apiResponse;
    }

}
