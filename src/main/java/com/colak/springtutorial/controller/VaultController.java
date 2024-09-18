package com.colak.springtutorial.controller;

import com.colak.springtutorial.service.VaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vault")
@RequiredArgsConstructor
public class VaultController {

    private final VaultService vaultService;


    // http://localhost:8080/vault/
    @GetMapping("/")
    public String getMsg() {
        return vaultService.getAge();
    }
}
