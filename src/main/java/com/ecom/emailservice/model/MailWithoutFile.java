package com.ecom.emailservice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MailWithoutFile implements Serializable {

    private String subject;

    private String body;

    private String recipentEmail;

}
