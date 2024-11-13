package com.colak.springtutorial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VaultService {

    @Value("${my_age}")
    public String age;

    private final VaultTemplate vaultTemplate;

    public String getAge() {
        return String.format("I am %s years old", age);
    }

    public void writeSecret(String path, Map<String, Object> secrets) {
        vaultTemplate.write(path, secrets);
    }

    // Another way of writing
    public void writeSecret2(String path, Map<String, String> secrets) {
        VaultKeyValueOperations operations = vaultTemplate.opsForKeyValue(path,
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
        operations.put(path, secrets);
    }

    public Map<String, Object> readSecret(String path) {
        VaultResponse response = vaultTemplate.read(path);
        return response != null ? response.getData() : null;
    }

    // Another way of reading
    public Map<String, Object> readSecret2(String path) {
        VaultResponse response = vaultTemplate.opsForKeyValue(path,
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2).get(path);
        return response.getData();
    }

}
