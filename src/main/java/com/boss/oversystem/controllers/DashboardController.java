package com.boss.oversystem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    /* el proyecto pasará a ser una api asi que no sé que haré con esto */
    @GetMapping("/dashboard")
    public BodyBuilder Dashboard(@AuthenticationPrincipal UserDetails userDetails) {

        return ResponseEntity.ok();
    }

}
