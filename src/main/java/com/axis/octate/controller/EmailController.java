	package com.axis.octate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.octate.constant.PermissionURLConstants;
import com.axis.octate.dto.EmailRequestDto;
import com.axis.octate.exception.AwsSesException;
import com.axis.octate.service.AwsSesService;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/access")
public class EmailController {

	@Autowired
    AwsSesService awsSesService;

    @Autowired
    public EmailController(AwsSesService awsSesService) {
        this.awsSesService = awsSesService;
    }

    @PostMapping(value = "/hr/email", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailRequestDto emailRequestDto) {
    	
    	awsSesService.setSender(emailRequestDto.getFrom());
    	awsSesService.setSubject(emailRequestDto.getSubject());
    	
    	
        try {
            awsSesService.sendEmail(emailRequestDto.getEmail(), emailRequestDto.getBody());
            return ResponseEntity.ok("Successfully Sent Email");
        } catch (AwsSesException e) {
            return ResponseEntity.status(500).body("Error occurred while sending email " + e);
        }
    }
}
