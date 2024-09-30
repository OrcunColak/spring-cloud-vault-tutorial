package com.colak.springtutorial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VaultService {

    @Value("${my_age}")
    public String age;

    private final VaultTemplate vaultTemplate;

    public String getAge(){
        return String.format("I am %s years old",age);
    }

    public void writeSecret(String path, Map<String, Object> secrets) {
        vaultTemplate.write(path, secrets);
    }

    public Map<String, Object> readSecret(String path) {
        VaultResponse response = vaultTemplate.read(path);
        return response != null ? response.getData() : null;
    }

}
