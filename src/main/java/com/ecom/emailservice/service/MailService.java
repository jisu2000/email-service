package com.ecom.emailservice.service;

import com.ecom.emailservice.model.MailWithoutFile;
import com.ecom.emailservice.playload.ApiResponse;

import jakarta.mail.Message;

public interface MailService {

    ApiResponse sendMaiilWithOutFile(MailWithoutFile msg);
}
